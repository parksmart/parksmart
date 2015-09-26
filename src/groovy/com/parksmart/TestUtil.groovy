package com.parksmart

import grails.mongodb.geo.Point

class TestUtil {

    def static save(def obj){
        if(!obj.save(flush:true)){
            println "Failed to save.. ${obj.errors}"
        }
        obj
    }

    void createUser(String name){
        User user = new User()
        user.username = name
        user.password = 'test'
        user.enabled = true
        save(user)
    }


    static void createAdvertisements(){
        List ads = [
                [name: 'Spacious parking with a cycle near CyberCity, Gurgaon', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910442, 77.0901351]],
                [name: 'Spacious parking with a cycle in Gurgaon', address: 'House No 25, Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910443, 77.0901350]],
                [name: 'A cool parking with a cycle', address: 'House No 240, Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910444, 77.0901350]],
                [name: 'Parking with a cycle', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910445, 77.0901351]],
                [name: 'A cool parking with a cycle', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910442, 77.0901351]],

                [name: 'Spacious parking with a cycle near CyberCity, Gurgaon', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'Parking with a cycle', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'A cool parking with a cycle', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'A cool parking with a cycle at awesome location', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'Beat the traffic - parking + cycle near CyberCity', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'Beat the traffic - parking in DLF Phase 2', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
        ]

        ads.each {Map ad->
            Advertisement advertisement = new Advertisement(ad)
            save(advertisement)
        }

        assert Advertisement.count() == ads.size()

    }

    void createParkingOnlyAd(String title, User user){

    }

}
