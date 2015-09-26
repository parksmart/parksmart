package com.parksmart

import grails.mongodb.geo.Point
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(AdvertisementService)
@Mock([Advertisement, Availability])
class AdvertisementServiceSpec extends Specification {

    static transactional = false

    void "test canary"() {
        expect:
        true
    }

    void "should create 30 availabities entries"() {
        when:
        Advertisement advertisement = new Advertisement(name: 'C. P., Gali Number 13, Anand Parbat, Delhi', location: [28.66202977d,180517d], geoLocation: new Point(28.66202977d,180517d), numberOfParkingSlots: 1, numberOfCycles: 0, ownerId: 11l, daysAvailable: DayType.values()).save(validate: false, flush: true)
        service.createAvailabilities(advertisement)

        then:
        Availability.count() == 30

    }

    void "should create 60 availabilities entries"() {
        when:
        Advertisement advertisement = new Advertisement(name: 'C. P., Gali Number 13, Anand Parbat, Delhi', location: [28.66202977d,180517d], geoLocation: new Point(28.66202977d,180517d), numberOfParkingSlots: 2, numberOfCycles: 0, ownerId: 11l, daysAvailable: DayType.values()).save(validate: false, flush: true)
        service.createAvailabilities(advertisement)

        then:
        Availability.count() == 60
    }

}
