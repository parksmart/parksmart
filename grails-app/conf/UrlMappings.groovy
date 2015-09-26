class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/advertisements"(resources:'advertisement')

        "/"(controller: "public", action: "home")
        "500"(view:'/error')
	}
}
