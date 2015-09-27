package com.parksmart

class AdvertisementResult extends Advertisement {


    AdvertisementResult() {
        super()
    }

    AdvertisementResult(Advertisement advertisement) {
        name=advertisement?.name
        address = advertisement?.address
        city = advertisement?.address
        locality = advertisement?.address
        numberOfParkingSlots = advertisement?.numberOfParkingSlots
        numberOfCycles = advertisement?.numberOfCycles
        pricePerParkingSlot = advertisement?.pricePerParkingSlot
        pricePerCycle = advertisement?.pricePerCycle
        geoLocation = advertisement?.geoLocation
        location = advertisement?.location
        daysAvailable = advertisement?.daysAvailable
        ownerId = advertisement?.ownerId

    }

    List<String> parkingAvailabilityRange
    List<String> cycleAvailabilityRange

}
