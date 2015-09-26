package com.parksmart

class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
    String name
    String mobileNumber
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	User(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	User(){

	}

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof User && other.username == username)
	}

	@Override
	String toString() {
		username
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
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
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
        accountExpired nullable:true
        accountLocked nullable: true
        passwordExpired nullable:true
        mobileNumber nullable: true
	}

	static mapping = {
		password column: '`password`'
	}

    static User getInstance(RegisterCO registerCO){
        User user = new User()
        user.name = registerCO.name
        user.mobileNumber = registerCO.mobileNumber
        user.password = registerCO.password
        user.username = registerCO.username
        user
    }
}


