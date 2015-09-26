package com.parksmart

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
    List<Double> location
    List<Integer> daysAvailable
    Long ownerId

    static constraints = {
        name()
        location()
        address()
        city(nullable: true)
        locality(nullable: true)
        numberOfParkingSlots()
        numberOfCycles()
        pricePerParkingSlot()
        pricePerCycle()
        daysAvailable()
        owner()

    }

    static mapping = {
        address type: 'text'
        location geoIndex: '2d', indexAttributes: [min: -5, max: 5]
    }

    static mapWith = "mongo"

    static transients = ['ownerId']

    User getOwner() {
        User.get(ownerId)
    }

    void setLocation(List location) {
        this.location = location ? [(0d + location[0]), (0d + location[1])] : []
    }
}
