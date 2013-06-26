import eaccount.User;
import eaccount.Role;
import eaccount.UserRole;

class BootStrap {
def springSecurityService
    def init = { servletContext ->
        println("initialising bootstrap")

		User sandboxUser = new User(firstName:"faisal",
			 middleName:"hero",
			 lastName:"teacher",
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
                User sandboxStudentUser = new User(firstName:"gita",
			 middleName:"student",
			 lastName:"thapa",
			 username:"gita",
                         password:"gita").save()



		if(sandboxStudentUser){
			println("sandboxStudentUser created")
	         	def role = Role.findByAuthority("ROLE_STUDENT")
			if(role==null){
				role = new Role(authority: "ROLE_STUDENT")
		                role.save(flush: true)
				println("role created")
			}

     	                def userrole = new UserRole(user: sandboxUser,role: role)
	                userrole.save(flush: true)

		}else{
			println("sandboxStudentUser already exists")
		}
                
    }
    def destroy = {
    }
}
