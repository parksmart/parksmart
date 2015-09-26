package com.parksmart

import grails.validation.Validateable
import org.grails.databinding.BindingFormat

@Validateable
class AdvertisementSearchCO {
    @BindingFormat("MM/dd/yyyy")
    Date startDate
    @BindingFormat("MM/dd/yyyy")
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


}
