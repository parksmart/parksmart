package com.parksmart

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

    private DateTime getCurrentDateTime() {
        new DateTime()
    }
}
