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

        List userIdList = User.list()*.id

        List ads = [
                [name: 'Spacious parking with a cycle near CyberCity, Gurgaon', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 0, pricePerParkingSlot: 0, pricePerCycle: 10, location: [28.4910442, 77.0901351]],
                [name: 'Spacious parking with a cycle in Gurgaon', address: 'House No 25, Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 0, location: [28.4910443, 77.0901350]],
                [name: 'A cool parking with a cycle', address: 'House No 240, Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910444, 77.0901350]],
                [name: 'Parking with a cycle', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910445, 77.0901351]],
                [name: 'A cool parking with a cycle', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 0, pricePerParkingSlot: 0, pricePerCycle: 20, location: [28.4910442, 77.0901351]],

                [name: 'Spacious parking with a cycle near CyberCity, Gurgaon', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'Parking with a cycle', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'A cool parking with a cycle', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 50, pricePerCycle: 0, location: [28.488467, 77.08386599999994]],
                [name: 'A cool parking with a cycle at awesome location', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'Beat the traffic - parking + cycle near CyberCity', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1,numberOfParkingSlots: 0, pricePerParkingSlot: 0, pricePerCycle: 15, location: [28.488467, 77.08386599999994]],
                [name: 'Beat the traffic - parking in DLF Phase 2', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 0, location: [28.488467, 77.08386599999994]],
        ]

        ads.each {Map ad->
            Advertisement advertisement = new Advertisement(ad)
            advertisement.geoLocation  = new Point(advertisement.location[0], advertisement.location[1])
            advertisement.ownerId = getRandom(userIdList)
            advertisement.startTime = "08:00"
            advertisement.endTime = "18:00"
            advertisement.daysAvailable = DayType.values() - [DayType.Saturday, DayType.Sunday]
            save(advertisement)
        }
        assert Advertisement.count() == ads.size()

    }

    static def getRandom(List list){
        list.get((Math.random() * list?.size() - 1) as Integer)
    }

    void createParkingOnlyAd(String title, User user){

    }

}
