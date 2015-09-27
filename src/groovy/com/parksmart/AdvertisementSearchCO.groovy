package com.parksmart

import grails.validation.Validateable
import org.grails.databinding.BindingFormat

@Validateable
class AdvertisementSearchCO {
    @BindingFormat("yyyy-MM-dd")
    Date startDate
    @BindingFormat("yyyy-MM-dd")
    Date endDate
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

    Integer getRadiusInKm() {
        radiusInKm?:5
    }
}
