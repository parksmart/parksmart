package com.parksmart

import com.mongodb.AggregationOutput
import com.mongodb.DBCollection
import grails.mongodb.geo.Distance
import grails.mongodb.geo.Metric
import org.joda.time.DateTime

class AdvertisementService {

    final static Integer DEFAULT_AVAILABILITY_DURATION_IN_DAYS = 30


    void createAvailabilities(Advertisement advertisement) {
        DateTime startDate = currentDateTime
        DateTime endDate = currentDateTime?.plusDays DEFAULT_AVAILABILITY_DURATION_IN_DAYS
        while(startDate < endDate) {
            if(startDate?.dayOfWeek in advertisement.daysAvailable*.value) {
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

    AggregationOutput aggregateAndFindAvailability(AdvertisementSearchCO advertisementSearchCO) {
        DBCollection availabilityCollection = Availability.collection

        availabilityCollection.aggregate(
                ['$match': ['date': ['$gt': advertisementSearchCO?.startDate, '$lt': advertisementSearchCO?.endDate],
                            'geoLocation': ['$geoWithin': ['$centerSphere': [advertisementSearchCO?.center,new Distance(advertisementSearchCO?.radiusInKm, Metric.KILOMETERS).inRadians()]]]]
                ],
                ['$group': ['_id': ['advertisementId': '$advertisementId', 'type': '$type'],
                        'advertisementId': [ '$first': '$advertisementId'] ,'type': ['$first': '$type'] ,'availabilityRange': ['$addToSet': ['$dayOfMonth': '$date']]
                ]],
                ['$group': ['_id': ['advertisementId': '$advertisementId'],
                        'advertisementId': ['$first': '$advertisementId'], 'availabilityRange': ['$push': ['type': '$type', 'value':'$availabilityRange']]
                ]])
    }

    private DateTime getCurrentDateTime() {
        new DateTime()
    }

    final String sequenceOfNumToArrayOfRangeJavaScriptFunction = '''
function getRanges(array) {
  var ranges = [], rstart, rend;
  for (var i = 0; i < array.length; i++) {
    rstart = array[i];
    rend = rstart;
    while (array[i + 1] - array[i] == 1) {
      rend = array[i + 1]; // increment the index if the numbers sequential
      i++;
    }
    ranges.push(rstart == rend ? rstart+'' : rstart + '-' + rend);
  }
  return ranges;
}'''
}
