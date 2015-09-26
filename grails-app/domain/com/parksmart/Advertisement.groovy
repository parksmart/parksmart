package com.parksmart

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
    User owner

    static constraints = {
        name()
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
        location geoIndex:'2d', indexAttributes:[min:-5, max:5]
    }

    static mapWith = "mongo"

    static transients = ['ownerId']

    User getOwnerId() {
        owner?.id
    }
}
