package com.parksmart

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_USER'])
class UserController {

    def homePage(){

    }

    def myProfile(Long currentUserId){
        User currentUser = User.get(currentUserId)

        List<Booking> myBookingList = Booking.findAllByCustomerId(currentUserId)
        List<Advertisement> myAdvertisementList = Advertisement.findAllByOwnerId(currentUserId)
        List<Booking> myRentOutBookings = Booking.findAllByOwnerId(currentUserId)


        int myBookingDaysCount = myBookingList?.sum {Booking booking-> booking?.daysCount}?:0

        [currentUser:currentUser,
                myBookingList:myBookingList,
                myAdvertisementList :myAdvertisementList ,
                myRentOutBookings: myRentOutBookings,
                myBookingDaysCount: myBookingDaysCount
        ]
    }



    def test(){
        Long currentUserId = params.currentUserId
        println("currentUserId: ${currentUserId}")
        List<Booking> myRentOutBookings = Booking.findAllByOwnerId(currentUserId)
        println("myRentOutBookings: ${myRentOutBookings*.id}")
        render"DONE!!!!"
    }
}
