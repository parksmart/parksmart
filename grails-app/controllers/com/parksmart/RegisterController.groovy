package com.parksmart

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class RegisterController {

    def userService
    def messageSource
    def springSecurityService

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

    def login() {
        Map responseMap = [status: false]
        if(params.get('j_password') && params.get('j_username')){
            User user = User.findByUsernameAndPassword(params.j_username, params.get('j_password'));
            if (user) {
                responseMap = [status: true, userId: user.id]
            }
        }
        render(responseMap as JSON)
    }
}
