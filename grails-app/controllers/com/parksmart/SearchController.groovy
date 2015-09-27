package com.parksmart

import grails.plugin.springsecurity.annotation.Secured

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
class SearchController {

    def index() {
    }

    def renderCards(){
        List<Long> advertisementIds = params['advertisementIds[]'].collect{
            it as Long
        }
        render template: 'renderCards', model: [advertisements : Advertisement.findAllByIdInList(advertisementIds), ifViewerIsOwner:false]
    }
}
