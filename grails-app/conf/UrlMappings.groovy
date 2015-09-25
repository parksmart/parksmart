class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/api/v1.0/$controller/$id"(parseRequest: true) {
            action = [GET: "show", PUT: "update", DELETE: "delete"]
            constraints {
                id(matches: /\d+/)
            }
        }

        "/api/v1.0/$controller"(parseRequest: true) {
            action = [GET: "list", POST: "save"]
        }

        "/api/v1.0/$controller/$action"(parseRequest: true)

        "/api/v1.0/$controller/$action/$id"(parseRequest: true)

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
