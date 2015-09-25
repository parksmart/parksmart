package com.parksmart

import grails.validation.Validateable

@Validateable
class AdvertisementSearchCO {
    BigDecimal latitude
    BigDecimal longitude
    Integer radiusInKm

    static constraints = {
        latitude nullable: false
        longitude nullable: false
        radiusInKm nullable: false
    }
}
