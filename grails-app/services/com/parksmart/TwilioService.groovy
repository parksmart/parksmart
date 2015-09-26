package com.parksmart

import com.twilio.sdk.TwilioRestClient
import com.twilio.sdk.TwilioRestException
import com.twilio.sdk.resource.factory.MessageFactory
import com.twilio.sdk.resource.instance.Message
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair

class TwilioService {

    def grailsApplication

    String send(String sender, String recipient, String body) throws RuntimeException {
        TwilioRestClient client = getTwilioRestClient()
        if (client) {
            MessageFactory factory = client.getAccount().getMessageFactory();
            Message sms
            try {
                List<NameValuePair> params = []
                params.add(new BasicNameValuePair("To", recipient))
                params.add new BasicNameValuePair("From", sender)
                params.add new BasicNameValuePair("Body", body)
                sms = factory.create(params)
                log.info "Sent SMS from ${sender} to ${recipient}: ${sms?.status}"
            } catch (TwilioRestException ex) {
                throw new RuntimeException("ErrorCode: ${ex.errorCode}, Message: ${ex.errorMessage}")
            }
            sms?.status
        } else {
            log.error("No client object could be created from twilio rest client configuration.")
        }
    }

    TwilioRestClient getTwilioRestClient() {
        def client = null
        if (grailsApplication.config.sms.useTestCredentials) {
            client = new TwilioRestClient(grailsApplication.config.twilio.testAccountSid, grailsApplication.config.twilio.testAuthToken)
            log.info("Using the twilio test credentials")
        } else {
            if (grailsApplication.config.twilio.accountSid && grailsApplication.config.twilio.authToken) {
                client = new TwilioRestClient(grailsApplication.config.twilio.accountSid, grailsApplication.config.twilio.authToken)
                log.info("Using the twilio live credentials")
            } else {
                log.error("Missing account SID and auth token in the configuration.")
            }
        }
        client
    }

}
