class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/advertisements"(resources:'advertisement')
        "/bookings"(resources:'booking')

        "/"(controller: "public", action: "home")
        "500"(view:'/error')
	}
}
