package com.parksmart

import grails.validation.Validateable

@Validateable
class RegisterCO {
    String username
    String password
    String name
    String mobileNumber

    static constraints = {
        username blank: false
        password blank: false
        name blank: false
        mobileNumber nullable: true
    }
}
