package com.parksmart

import grails.mongodb.geo.Point
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
@Transactional(readOnly = true)
class AdvertisementController extends RestfulController {

    def advertisementService

    static responseFormats = ['html', 'json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static final Integer DEFAULT_RADIUS = 5

    AdvertisementController() {
        super(Advertisement)
    }

    def index(AdvertisementSearchCO advertisementSearchCO) {
        bindData(advertisementSearchCO, params)
        advertisementSearchCO?.validate()
        if (advertisementSearchCO.hasErrors()) {
            respond advertisementSearchCO.errors
            return
        }
        respond advertisementService.findAllAdvertisements(advertisementSearchCO)
    }

    def show(Advertisement advertisementInstance) {
        respond advertisementInstance
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    def create() {
        Advertisement advertisementInstance = new Advertisement()
        respond advertisementInstance
    }

    @Transactional
    def save(Advertisement advertisementInstance) {
        if (advertisementInstance == null) {
            notFound()
            return
        }

        if (advertisementInstance.hasErrors()) {
            respond advertisementInstance, view: 'create'
            return
        }

        advertisementInstance.geoLocation = new Point(advertisementInstance.location[0], advertisementInstance.location[1])
        advertisementInstance.save flush: true
        advertisementService.createAvailabilities(advertisementInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'advertisement.posted')
                respond advertisementInstance, view: 'show'
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
            respond advertisementInstance.errors, view: 'edit'
            return
        }

        advertisementInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Advertisement.label', default: 'Advertisement'), advertisementInstance.id])
                redirect advertisementInstance
            }
            '*' { respond advertisementInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Advertisement advertisementInstance) {

        if (advertisementInstance == null) {
            notFound()
            return
        }

        advertisementInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Advertisement.label', default: 'Advertisement'), advertisementInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'advertisement.label', default: 'Advertisement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
