package park.smart

import grails.util.Environment

class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                String envName = Environment.current.name
                if (["qa", "development"]?.contains(envName)) {
                    log.info "Logs: >> ${params}"
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
