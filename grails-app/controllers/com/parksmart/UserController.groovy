package com.parksmart

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_USER'])
class UserController {

    def homePage(){

    }

    def myProfile(Long currentUserId){
        User currentUser = User.get(currentUserId)

        List<Booking> bookingList = Booking.findAllByCustomerId(currentUserId)

        [currentUser:currentUser]
    }
}
