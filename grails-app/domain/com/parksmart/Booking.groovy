package com.parksmart

import grails.rest.Resource
import org.grails.databinding.BindingFormat

@Resource
class Booking {
    Long advertisementId
    Long ownerId
    Long customerId
    @BindingFormat("yyyy-MM-dd")
    Date startDate
    @BindingFormat("yyyy-MM-dd")
    Date endDate
    Integer amount
    Boolean isParking
    Boolean isCycle

    Date dateCreated
    Date lastUpdated

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

    Long getOwnerId() {
        return ownerId ?: Advertisement.get(advertisementId)?.ownerId
    }

    Integer getAmount() {
        Advertisement advertisement = Advertisement.get(advertisementId)
        Integer numberOfDays = endDate - startDate
        Integer amount = 0;
        if(isParking){
            amount+= numberOfDays * advertisement?.pricePerParkingSlot
        }
        if(isCycle){
            amount+= numberOfDays * advertisement?.pricePerCycle
        }
        return amount
    }



    static transients = ['advertisement', 'owner', 'customer']

    Advertisement getAdvertisement(){
        Advertisement.get(advertisementId)
    }

    User getOwner(){
        User.get(ownerId)
    }

    User getCustomer(){
        User.get(customerId)
    }

}
