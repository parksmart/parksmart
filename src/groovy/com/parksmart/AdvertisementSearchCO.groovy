package com.parksmart

import grails.validation.Validateable

@Validateable
class AdvertisementSearchCO {
    BigDecimal latitude
    BigDecimal longitude
    Integer radiusInKm = 5

    static constraints = {
        latitude nullable: false
        longitude nullable: false
        radiusInKm nullable: true
    }

    List getCenter() {
        latitude && longitude ? [0d + (latitude), 0d + (longitude)] : []
    }


}
