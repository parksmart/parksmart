package com.parksmart

import grails.plugin.springsecurity.annotation.Secured

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class SearchController {

    def index() {

    }
}
