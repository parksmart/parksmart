package com.parksmart

class Booking {
    Long advertisementId
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
        customerId()
        startDate()
        endDate()
        amount()
    }
}
