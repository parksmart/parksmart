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
    Long ownerId

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

    static transients = ['ownerId']

    User getOwner() {
        User.get(ownerId)
    }
}
