class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		//default route for login
		 "/" {
		    controller = "login"
		    action = "auth"
 		 }
		"500"(view:'/error')
	}
}
