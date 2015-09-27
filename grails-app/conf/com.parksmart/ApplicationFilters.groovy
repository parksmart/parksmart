package com.parksmart

class ApplicationFilters {

    def springSecurityService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if(!params.ownerId){
                    User user = springSecurityService.currentUser as User
                    params.ownerId = user?.id
                }
                println params
                return
            }
        }
    }
}
