package com.parksmart

import grails.validation.Validateable

@Validateable
class RegisterCO {
    String username
    String password
    String name
    String mobileNumber

    static constraints = {
        username blank: false, email: true, validator: { val, obj ->
            if (User.countByUsername(val)) {
                return "registerCO.username.unique.error"
            }
        }
        password blank: false
        name blank: false
        mobileNumber nullable: true
    }
}
