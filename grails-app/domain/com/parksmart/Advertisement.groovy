package com.parksmart

import grails.mongodb.geo.Point
import grails.rest.Resource

@Resource
class Advertisement {

    String name // or title
    String address
    String city
    String locality
    Integer numberOfParkingSlots
    Integer numberOfCycles
    Double pricePerParkingSlot
    Double pricePerCycle
    Point geoLocation
    List<Double> location
    List<DayType> daysAvailable
    Long ownerId

    static constraints = {
        name()
        geoLocation(nullable: true)
        location()
        address()
        city(nullable: true)
        locality(nullable: true)
        numberOfParkingSlots(nullable: true)
        numberOfCycles(nullable: true)
        pricePerParkingSlot(nullable: true)
        pricePerCycle(nullable: true)
        daysAvailable()
        owner()

    }

    static mapping = {
        address type: 'text'
        location geoIndex: '2d', indexAttributes: [min: -500, max: 500]
        geoLocation geoIndex: '2dsphere', indexAttributes: [min: -500, max: 500]
    }

    static mapWith = "mongo"

    static transients = ['owner']

    User getOwner() {
        User.get(ownerId)
    }

    void setLocation(List location) {
        this.location = location ? [(0d + location[0]), (0d + location[1])] : []
    }
}
