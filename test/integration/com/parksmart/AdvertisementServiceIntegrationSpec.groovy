package com.parksmart

import grails.mongodb.geo.Point
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

class AdvertisementServiceIntegrationSpec extends Specification {

    @Autowired
    AdvertisementService advertisementService

    void "testing aggregation of availability"() {

        when:
        Advertisement advertisement = new Advertisement(name: 'C. P., Gali Number 13, Anand Parbat, Delhi', location: [28.4910443, 77.0901350], geoLocation: new Point(28.4910443, 77.0901350), numberOfParkingSlots: 2, numberOfCycles: 0, ownerId: 11l, daysAvailable: DayType.values()).save(validate: false, flush: true)
        advertisementService.createAvailabilities(advertisement)
        advertisementService.aggregateAndFindAvailability(new AdvertisementSearchCO(latitude: 28.4910443d, longitude: 77.0901350d, startDate: new Date(), endDate: new Date() + 5, radiusInKm: 5))?.results()?.each {println it}

        then:
        true

        cleanup:
        advertisement.delete(flush: true)
    }

}
