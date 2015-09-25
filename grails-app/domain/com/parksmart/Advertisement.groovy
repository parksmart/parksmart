package com.parksmart

import com.parksmart.User

class Advertisement {

    String name
    String address
    String city
    String locality
    Integer numberOfParkingSlots
    Integer numberOfCycles
    Double pricePerParkingSlot
    Double pricePerCycle
    List location
    List<Integer> daysAvailable
    Long ownerId

    static constraints = {
        name()
        location()
        address()
        city()
        locality()
        numberOfParkingSlots()
        numberOfCycles()
        pricePerParkingSlot()
        pricePerCycle()
        daysAvailable()
        owner()

    }

    static mapping = {
        address type: 'text'
        location geoIndex:'2d', indexAttributes:[min:-5, max:5]
    }

    static mapWith = "mongo"

    static transients = ['ownerId']

    User getOwner() {
        User.get(ownerId)
    }
}
