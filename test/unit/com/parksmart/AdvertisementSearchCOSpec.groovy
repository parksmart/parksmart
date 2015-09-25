package com.parksmart

import grails.test.mixin.TestMixin
import grails.test.mixin.web.ControllerUnitTestMixin
import spock.lang.Specification

@TestMixin(ControllerUnitTestMixin)
class AdvertisementSearchCOSpec extends Specification {

    void "should say latitude is required"() {
        when:
        AdvertisementSearchCO advertisementSearchCO = new AdvertisementSearchCO(longitude: 482347d, latitude: null, radiusInKm: 5)
        new AdvertisementSearchCO().validate()

        then:
        advertisementSearchCO.errors.getFieldError('latitude').code == 'nullable'

    }

    void "should say longitude is required"() {
        when:
        AdvertisementSearchCO advertisementSearchCO = new AdvertisementSearchCO(longitude: null, latitude: 3423423d, radiusInKm: 5)
        new AdvertisementSearchCO().validate()

        then:
        advertisementSearchCO.errors.getFieldError('longitude').code == 'nullable'

    }

    void "should say radius is required"() {
        when:
        AdvertisementSearchCO advertisementSearchCO = new AdvertisementSearchCO(longitude: 482347d, latitude: 423423432d, radiusInKm: null)
        new AdvertisementSearchCO().validate()

        then:
        advertisementSearchCO.errors.getFieldError('radiusInKm').code == 'nullable'

    }
}
