package com.parksmart

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY','IS_AUTHENTICATED_FULLY'])
class StaticPagesController {

    def index() {
        redirect(controller: 'staticPages', action: 'homePage')
    }

    def homePage(){
//        render "implement homePage UI"
    }

    def searchResults(){
        render "implement searchResults page UI"
    }

    def requestBooking(){

    }

    def confirmBooking(){
        render "implement confirmBooking page UI"
    }

    def showBooking(){
        render "implement showBooking page UI"
    }

    def showAdvertisement(){
        render "implement showAdvertisement page UI"
    }

    def createAdvertisement(){
       
    }
}
