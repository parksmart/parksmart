package park.smart

import com.parksmart.User

class Advertisement {

    String name
    String address
    String city
    String locality
    Integer numberOfParkingSlots
    Integer numberOfCycles
    Double pricePerParkingSlot
    Double pricePerCycle
    List location
    List<Integer> daysAvailable
    User owner

    static constraints = {
        name()
        location()
        address()
        city()
        locality()
        numberOfParkingSlots()
        numberOfCycles()
        pricePerParkingSlot()
        pricePerCycle()
        daysAvailable()
        owner()

    }

    static mapping = {
        address type: 'text'
    }

    static mapWith = "mongo"
}
