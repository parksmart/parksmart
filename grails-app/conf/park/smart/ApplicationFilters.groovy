package park.smart

class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
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
