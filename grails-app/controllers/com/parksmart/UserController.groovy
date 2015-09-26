package com.parksmart

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured


@Secured(['IS_AUTHENTICATED_FULLY'])
class UserController {

    def userService
    def messageSource

    def signUp() {

    }

    def registerUser2(RegisterCO registerCO) {
        println("RegisterCO: ${registerCO.properties}")
        render([status: true] as JSON)
    }

    def registerUser(RegisterCO registerCO) {
        println("RegisterCO: ${registerCO.properties}")
        Map responseModel = [:]
        if (registerCO.validate()) {
            userService.registerUser(registerCO)
            responseModel = [status: true, message: "You have been registered successfully."]
        } else {
            List<String> errors = populateErrorMessages(registerCO)
            responseModel = [status: false, errors: errors]
        }
        render(responseModel as JSON)
    }

    List<String> populateErrorMessages(RegisterCO registerCO) {
        List<String> errorMessages = []
        registerCO.errors.allErrors.each { def objectError ->
            errorMessages << messageSource.getMessage(objectError, Locale.default)
        }
        return errorMessages
    }


}
