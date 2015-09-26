package com.parksmart

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_USER'])
class UserController {

    def homePage(){

    }

    def myProfile(Long currentUserId){
        User currentUser = User.get(currentUserId)

        List<Booking> bookingList = Booking.findAllByCustomerId(currentUserId)
//        List<Advertisement> advertisementList = Advertisement.list()
        List<Advertisement> advertisementList = Advertisement.findAllByOwnerId(currentUserId)
//        List<Advertisement> rentOutAdvertisementList = Advertisement.list()
        List<Advertisement> rentOutAdvertisementList = Advertisement.findAllByOwnerId(currentUserId)
        [currentUser:currentUser,
                bookingList:bookingList,
                advertisementList:advertisementList,
                rentOutAdvertisementList: rentOutAdvertisementList
        ]
    }
}
