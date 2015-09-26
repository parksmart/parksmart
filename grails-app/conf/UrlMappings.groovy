class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/advertisements"(resources:'advertisement')

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
