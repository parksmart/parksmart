package com.parksmart

class MailService {

    def mailService

    def sendEmail(MailDTO mailDTO) throws Exception {
        if (!mailDTO?.validate()) {
            throw new RuntimeException(mailDTO?.errors?.allErrors?.join("\n"))
        }
        mailService.sendMail {
            to mailDTO?.to
            subject mailDTO?.subject
            html mailDTO?.html
        }
    }

}
