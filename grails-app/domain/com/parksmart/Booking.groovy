package com.parksmart

import grails.rest.Resource
import org.grails.databinding.BindingFormat

@Resource
class Booking {
    Long advertisementId
    Long ownerId
    Long customerId
    @BindingFormat("MM/dd/yyyy")
    Date startDate
    @BindingFormat("MM/dd/yyyy")
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
