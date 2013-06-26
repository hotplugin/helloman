package eaccount

class User {

	transient springSecurityService

	String firstName;
    String middleName;
    String lastName;

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
        Student student;
        static belongsTo=Student;
	static constraints = {
		firstName(blank:false)
        middleName(blank:true)
        lastName(blank:false)

		username blank: false, unique: true
		password blank: false
                student nullable:true
                student blank:false;
                student display:false;
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}


	String toString(){
         "${firstName+" "+middleName+" "+lastName}";
    }
}
