package com.parksmart

import com.parksmart.Advertisement
import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
class AdvertisementController {

    def springSecurityService

    def create() {
        User user = springSecurityService.getCurrentUser() as User
        Advertisement advertisement = Advertisement.findByOwner(user) ?: new Advertisement()
        render view: 'create', model: [advertisement: advertisement]
    }

    def save(Advertisement advertisement) {
        println( params)
        User user = springSecurityService.getCurrentUser() as User
        advertisement.owner = user
        if (advertisement.validate()){
            advertisement.save()
            redirect action: 'create'
            return
        }else {
            render view: 'create', model: [advertisement: advertisement]
        }
    }

}
