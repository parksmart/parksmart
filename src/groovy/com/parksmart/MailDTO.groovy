package com.parksmart

import grails.validation.Validateable

@Validateable
class MailDTO {
    String to
    String from
    String subject
    String html
    String body

    static constraints = {
        to()
        from()
        subject()
        html()
        body()
    }
}
