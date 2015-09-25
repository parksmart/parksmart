package com.parksmart

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
@Transactional(readOnly = true)
class AdvertisementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(AdvertisementSearchCO advertisementSearchCO) {
        if (advertisementSearchCO.hasErrors()) {
            respond advertisementSearchCO.errors
            return
        }
        respond(Advertisement.findAllByLocationWithinCircle([advertisementSearchCO?.center, advertisementSearchCO?.radiusInKm]) ?: [])
    }

    def show(Advertisement advertisementInstance) {
        respond advertisementInstance
    }

    def create() {
        respond new Advertisement(params)
    }

    @Transactional
    def save(Advertisement advertisementInstance) {
        if (advertisementInstance == null) {
            notFound()
            return
        }

        if (advertisementInstance.hasErrors()) {
            respond advertisementInstance.errors, view:'create'
            return
        }

        advertisementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'advertisement.label', default: 'Advertisement'), advertisementInstance.id])
                redirect advertisementInstance
            }
            '*' { respond advertisementInstance, [status: CREATED] }
        }
    }

    def edit(Advertisement advertisementInstance) {
        respond advertisementInstance
    }

    @Transactional
    def update(Advertisement advertisementInstance) {
        if (advertisementInstance == null) {
            notFound()
            return
        }

        if (advertisementInstance.hasErrors()) {
            respond advertisementInstance.errors, view:'edit'
            return
        }

        advertisementInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Advertisement.label', default: 'Advertisement'), advertisementInstance.id])
                redirect advertisementInstance
            }
            '*'{ respond advertisementInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Advertisement advertisementInstance) {

        if (advertisementInstance == null) {
            notFound()
            return
        }

        advertisementInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Advertisement.label', default: 'Advertisement'), advertisementInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'advertisement.label', default: 'Advertisement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
