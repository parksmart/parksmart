package com.parksmart

import grails.mongodb.geo.Distance
import grails.mongodb.geo.Metric
import grails.mongodb.geo.Point
import grails.mongodb.geo.Sphere
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
@Transactional(readOnly = true)
class AdvertisementController extends RestfulController {

    def springSecurityService

    static responseFormats = ['html', 'json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
//        DBCursor cursor = Advertisement.collection.find(['geoLocation': ['$geoWithin': ['$centerSphere': [advertisementSearchCO?.center, new Distance(5, Metric.KILOMETERS).inRadians()]]]])
        /*

        List<Advertisement> advertisementList = []
        while(cursor.hasNext()) {
            advertisementList << (cursor.next() as Advertisement)
        }*/
        respond Advertisement.findAllByGeoLocationGeoWithin(Sphere.valueOf([advertisementSearchCO?.center, new Distance(advertisementSearchCO?.radiusInKm, Metric.KILOMETERS).inRadians()]))
    }

    def show(Advertisement advertisementInstance) {
        respond advertisementInstance
    }

    def create() {
        User user = springSecurityService.currentUser as User
        Advertisement advertisementInstance = Advertisement.findByOwner(user) ?: new Advertisement()
        respond advertisementInstance
    }

    @Transactional
    def save(Advertisement advertisementInstance) {
        println params
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

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'advertisement.label', default: 'Advertisement'), advertisementInstance.id])
                respond advertisementInstance, view: 'create'
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
