package com.parksmart

import com.mongodb.AggregationOutput
import com.mongodb.DBCollection
import grails.mongodb.geo.Distance
import grails.mongodb.geo.Metric
import org.joda.time.DateTime

class AdvertisementService {

    final static Integer DEFAULT_AVAILABILITY_DURATION_IN_DAYS = 30


    void createAvailabilities(Advertisement advertisement, Integer durationInDays = DEFAULT_AVAILABILITY_DURATION_IN_DAYS) {
        DateTime startDate = currentDateTime
        DateTime endDate = currentDateTime?.plusDays durationInDays
        while (startDate < endDate) {
            if (startDate?.dayOfWeek in advertisement.daysAvailable*.value) {
                advertisement?.numberOfParkingSlots?.times {
                    new Availability(date: startDate?.toDate(), advertisementId: advertisement?.id, location: advertisement.location, geoLocation: advertisement.geoLocation, type: AvailabilityType.PARKING).save(flush: true)
                }
                advertisement?.numberOfCycles?.times {
                    new Availability(date: startDate?.toDate(), advertisementId: advertisement?.id, location: advertisement.location, geoLocation: advertisement.geoLocation, type: AvailabilityType.CYCLE).save(flush: true)
                }
            }
            startDate = startDate?.plusDays(1)
        }
    }

    void deleteAvailability(Booking booking) {
        List types = []
        if (booking?.isCycle) {
            types << AvailabilityType.CYCLE
        }
        if (booking?.isParking) {
            types << AvailabilityType.PARKING
        }
        Date startDate = booking?.startDate
        Date endDate = booking?.endDate
        while (startDate <= endDate) {
            Availability.findByAdvertisementIdAndDateAndTypeInList(booking?.advertisementId, startDate, types)?.delete()
            startDate = startDate + 1
        }
    }

    List<AdvertisementResult> findAllAdvertisements(AdvertisementSearchCO advertisementSearchCO) {
        AggregationOutput aggregationOutput = aggregateAndFindAvailability(advertisementSearchCO)
        List<AdvertisementResult> advertisementResultsList = aggregationOutput?.results()?.inject([]) { List<AdvertisementResult> advertisementResults, aggregationResult ->
            AdvertisementResult advertisementResult = new AdvertisementResult(Advertisement.get(aggregationResult?.advertisementId))
            if (aggregationResult?.availabilityRange?.size() > 0 && aggregationResult?.availabilityRange[0]?.type == AvailabilityType.PARKING.toString()) {
                advertisementResult.parkingAvailabilityRange = convertSequenceOfNumToArrayOfRange(aggregationResult?.availabilityRange[0]?.value)
            }
            if (aggregationResult?.availabilityRange?.size() > 1 && aggregationResult?.availabilityRange[1]?.type == AvailabilityType.PARKING.toString()) {
                advertisementResult.parkingAvailabilityRange = convertSequenceOfNumToArrayOfRange(aggregationResult?.availabilityRange[1]?.value)
            }
            if (aggregationResult?.availabilityRange?.size() > 0 && aggregationResult?.availabilityRange[0]?.type == AvailabilityType.CYCLE.toString()) {
                advertisementResult.cycleAvailabilityRange = convertSequenceOfNumToArrayOfRange(aggregationResult?.availabilityRange[0]?.value)
            }
            if (aggregationResult?.availabilityRange?.size() > 1 && aggregationResult?.availabilityRange[1]?.type == AvailabilityType.CYCLE.toString()) {
                advertisementResult.cycleAvailabilityRange = convertSequenceOfNumToArrayOfRange(aggregationResult?.availabilityRange[1]?.value)
            }
            advertisementResults << advertisementResult
            advertisementResults
        }
        advertisementResultsList
    }

    AggregationOutput aggregateAndFindAvailability(AdvertisementSearchCO advertisementSearchCO) {
        DBCollection availabilityCollection = Availability.collection

        availabilityCollection.aggregate(
                ['$match': ['date'       : ['$gt': advertisementSearchCO?.startDate, '$lt': advertisementSearchCO?.endDate],
                            'geoLocation': ['$geoWithin': ['$centerSphere': [advertisementSearchCO?.center, new Distance(advertisementSearchCO?.radiusInKm, Metric.KILOMETERS).inRadians()]]]]
                ],
                ['$sort': ['date': 1]],
                ['$group': ['_id'            : ['advertisementId': '$advertisementId', 'type': '$type'],
                            'advertisementId': ['$first': '$advertisementId'], 'type': ['$first': '$type'], 'availabilityRange': ['$push': '$date']
                ]],
                ['$group': ['_id'            : ['advertisementId': '$advertisementId'],
                            'advertisementId': ['$first': '$advertisementId'], 'availabilityRange': ['$push': ['type': '$type', 'value': '$availabilityRange']]
                ]])
    }

    private DateTime getCurrentDateTime() {
        new DateTime()
    }

    List convertSequenceOfNumToArrayOfRange1(List<Integer> availabilities) {
        def hold
        List str = []

        availabilities?.eachWithIndex { Integer it, i ->
            if ((it) +1 == (availabilities[i + 1] as Integer)) {
                if (!hold) hold = it
            } else {
                str += hold ? "$hold-${it}" : "${it}"
                hold = null
            }
        }

        str[0..(str.size() - 3)]
    }

    List convertSequenceOfNumToArrayOfRange(List<Date> availabilities) {
        availabilities?.sort()

        Date lastDate = null
        Date currStartRange = null
        Date currEndRange = null

        List dateRanges = []

        for (int i = 0; i < availabilities.size(); i++) {
            Date currDate = availabilities.get(i)

            if (lastDate) {
                int dayDiff = currDate - lastDate
                if (dayDiff == 1) {
                    // we are good
                } else {
                    currEndRange = lastDate
                    dateRanges << [currStartRange, currEndRange]
                }
            } else {
                currStartRange = currDate
            }

            if (i == availabilities.size() - 1) {
                currEndRange = lastDate
                dateRanges << [currStartRange, currEndRange]
            }

            lastDate = currDate
        }
        dateRanges
    }
}
