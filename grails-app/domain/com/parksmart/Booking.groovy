package com.parksmart

import grails.rest.Resource

@Resource
class Booking {
    Long advertisementId
    Long ownerId
    Long customerId
    Date startDate
    Date endDate
    Integer amount
    Boolean isParking
    Boolean isCycle

    static constraints = {
        advertisementId()
        isParking(nullable: true)
        isCycle(nullable: true)
        ownerId()
        customerId()
        startDate()
        endDate()
        amount()
    }
}
