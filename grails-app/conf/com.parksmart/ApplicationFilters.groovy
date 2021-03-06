package com.parksmart

class ApplicationFilters {

    def springSecurityService

    def filters = {

        all(controller: '*', action: '*'){
            before = {
                println params
                if(!params.currentUserId && springSecurityService.isLoggedIn()){
                    params.currentUserId = springSecurityService.currentUser.id
                }
            }
        }

        advertisement(controller:'advertisement', action:'*') {
            before = {
                if(!params.ownerId){
                    User user = springSecurityService.currentUser as User
                    params.ownerId = user?.id
                }


                if(!params.currentUserId && springSecurityService.isLoggedIn()){
                    params.currentUserId = springSecurityService.currentUser.id
                }
            }
        }

        booking(controller:'*', action:'*') {
            before = {
                if(!params.customerId){
                    User user = springSecurityService.currentUser as User
                    params.customerId = user?.id
                }

                if(!params.currentUserId && springSecurityService.isLoggedIn()){
                    params.currentUserId = springSecurityService.currentUser.id
                }
            }
        }


    }
}
