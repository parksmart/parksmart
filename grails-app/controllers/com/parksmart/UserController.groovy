package com.parksmart

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_USER'])
class UserController {

    def homePage(){

    }

}
