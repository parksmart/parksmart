package com.parksmart

import grails.util.Environment

class SmsService {

    def grailsApplication

    def twilioService

    def send(Long tenantId, String sender, String recipient, String body) throws Exception {
        sender = resolveSender(sender, Environment.current.name)
        recipient = resolveRecipient(recipient, Environment.current.name)
        if (Environment.current.name != 'production') {
            log.info "Sending SMS from ${sender} to ${recipient}: \'${body}\'"
        }
        String status = twilioService.send(sender, recipient, body)
        return status
    }


    String resolveSender(String sender, environmentName) {
        if (grailsApplication.config.sms.useTestCredentials) {
            if (environmentName == 'dev') {
                log.info("OVERRIDE: Updating sender to use test credentials: ${sender}")
                sender = '+15005550006'
            }
            sender
        }
    }

    String resolveRecipient(String recipient, environmentName) {
        String defaultRecipient
        if (environmentName == 'dev') {
            defaultRecipient = grailsApplication.config.sms.defaultRecipientWithLiveCredentials
        }
        recipient
    }

}
