import eaccount.User;
import eaccount.Role;
import eaccount.UserRole;

class BootStrap {

    def init = { servletContext ->
        println("initialising bootstrap")

		User sandboxUser = new User(firstName:"faisal",
			 middleName:"hero",
			 lastName:"adil",
			 username:"faisal@gmail.com",
                         password:"123456").save()



		if(sandboxUser){
			println("sandbox user created")
	         	def role = Role.findByAuthority("ROLE_ADMIN")
			if(role==null){
				role = new Role(authority: "ROLE_ADMIN")
		                role.save(flush: true)
				println("role created")
			}

     	                def userrole = new UserRole(user: sandboxUser,role: role)
	                userrole.save(flush: true)

		}else{
			println("user already exists")
		}
    }
    def destroy = {
    }
}
