package com.parksmart

import grails.mongodb.geo.Point

class Availability {

    Long advertisementId
    Date date
    List<Double> location
    Point geoLocation
    AvailabilityType type


    static constraints = {
        advertisementId()
        date()
        geoLocation(nullable: true)
        location()
        type()
    }

    static mapWith = "mongo"

    static mapping = {
        location geoIndex: '2d', indexAttributes: [min: -500, max: 500]
        geoLocation geoIndex: '2dsphere', indexAttributes: [min: -500, max: 500]
    }

}
