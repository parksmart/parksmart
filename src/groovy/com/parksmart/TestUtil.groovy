package com.parksmart

import grails.mongodb.geo.Point

class TestUtil {

    def static save(def obj) {
        if (!obj.save(flush: true)) {
            println "Failed to save.. ${obj.errors}"
        }
        obj
    }

    void createUser(String name) {
        User user = new User()
        user.username = name
        user.password = 'test'
        user.enabled = true
        save(user)
    }


    static void createAdvertisements() {

        List userIdList = User.list()*.id

        List ads = [
                [name: 'Spacious parking with a cycle near CyberCity, Gurgaon', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 0, pricePerParkingSlot: 50, pricePerCycle: 10, location: [28.4910442, 77.0901351]],
                [name: 'Spacious parking with a cycle in Gurgaon', address: 'House No 25, Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 0, numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 10, location: [28.4910443, 77.0901350]],
                [name: 'A cool parking with a cycle', address: 'House No 240, Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910444, 77.0901350]],
                [name: 'Parking with a cycle', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.4910445, 77.0901351]],
                [name: 'A cool parking with a cycle', address: 'Belverede Apartments-2, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 0, pricePerParkingSlot: 0, pricePerCycle: 20, location: [28.4910442, 77.0901351]],
                [name: 'Spacious parking with a cycle near CyberCity, Gurgaon', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'Parking with a cycle', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'A cool parking with a cycle', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 0, numberOfParkingSlots: 1, pricePerParkingSlot: 50, pricePerCycle: 40, location: [28.488467, 77.08386599999994]],
                [name: 'A cool parking with a cycle at awesome location', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 30, location: [28.488467, 77.08386599999994]],
                [name: 'Beat the traffic - parking + cycle near CyberCity', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 1, numberOfParkingSlots: 0, pricePerParkingSlot: 100, pricePerCycle: 150, location: [28.488467, 77.08386599999994]],
                [name: 'Beat the traffic - parking in DLF Phase 2', address: 'Corporate Apartments Gurgaon, Mushedpur, DLF Phase 2, Gurgaon, Haryana, India', numberOfCycles: 0, numberOfParkingSlots: 1, pricePerParkingSlot: 40, pricePerCycle: 10, location: [28.488467, 77.08386599999994]],
                [name: 'Easy Parking in Sector 24 Gurgaon', address:'Room#34, Lagoon Apartments, Ambience Island, DLF Phase 3, Sector 24, Gurgaon, Haryana 122002, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.50417,77.09673]],
                [name: 'Spacious parking available in DLF Phase 3', address: 'Room#102, V12/2, Lower Ground Floor, DLF City, Phase III, Gurgaon, Haryana 122002, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.492908,77.107436]],
                [name: 'Secure parking and a cycle at DLF Oakwood Estate', address: 'DLF Oakwood Estate, Akashneem Marg, Sector 25,Gurgaon, Haryana 122002,India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.4843538,77.0882538]],
                [name: 'Spacious parking available in Sector-28, Gurgaon', address: 'Room#127, Queens Apartments, Chakkarpur, Sector 28, Gurgaon, Haryana 122002, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.4712191,77.0935267]],
                [name: 'Beat the traffic - parking + cycle in DLF Phase 4', address: 'Room#52, Plot # 6902, DLF-IV, Near Super Mart-1, Gurgaon, Haryana 122009, India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 50, pricePerCycle: 35, location: [28.4655011,77.0877279]],
                [name: 'Easy Parking in DLF Phase 3 Gurgaon', address:'Room#566,Ambience Caitriona Apartments, Lane Number V-20, DLF Phase 3, Sector 24, Gurgaon, Haryana, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.5009515,77.1032739]],
                [name: 'Spacious parking available in DLF Phase 2', address: 'Room#130,Krishna Residency,Dlf City, 81, Phase II, Gurgaon, Haryana 122002, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.492908,77.107436]],
                [name: 'Get a secure parking and a cycle available in Phase 2', address: 'M-13 Rd,DLF Phase 2, Sector 25,Gurgaon, Haryana 122002,India', numberOfCycles: 1,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.4890602,77.086654]],
                [name: 'Spacious parking available in Sector 25, Gurgaon', address: 'Room#147, The Imperial Inn M-10 Block Q DLF City Phase 2 Road,Sector 25,Gurgaon, Haryana, India', numberOfCycles: 0,numberOfParkingSlots: 1, pricePerParkingSlot: 45, pricePerCycle: 25, location: [28.4888259,77.0852502]],
        ]

        ads.each { Map ad ->
            Advertisement advertisement = new Advertisement(ad)
            advertisement.startTime = "08:00"
            advertisement.endTime = "18:00"
            advertisement.geoLocation = new Point(advertisement.location[0], advertisement.location[1])
            advertisement.ownerId = (Long)getRandom(userIdList)
            advertisement.daysAvailable = DayType.values()
            save(advertisement)
        }
        assert Advertisement.count() == ads.size()
    }

    static void createBookings() {
        Advertisement.list().each { Advertisement advertisement ->
            int userCount = User.count()
            Booking booking = new Booking(advertisementId: advertisement.id,
                    ownerId: advertisement.ownerId,
                    customerId: User.get(Math.random() * userCount)?.id ?: 1,
                    startDate: new Date() + 5,
                    endDate: new Date() + 10,
                    amount: 100,
                    isParking: advertisement.id % 2 ? false : true,
                    isCycle: true,
                    address: advertisement.address,
                    location: advertisement.location
            )
            save(booking)
        }
        assert Booking.count() >= Advertisement.count() / 2
    }

    static def getRandom(List list) {
        list.get((Math.random() * list?.size() - 1) as Integer)
    }

    void createParkingOnlyAd(String title, User user) {

    }

}
