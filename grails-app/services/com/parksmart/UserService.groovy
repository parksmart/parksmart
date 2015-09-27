package com.parksmart

class UserService {

    User registerUser(RegisterCO registerCO){
        User user = User.getInstance(registerCO)
        user.save(flush:true, failOnError: true)
        Role role = Role.findByAuthority('ROLE_USER')
        UserRole.create(user, role, true )
        user
    }

}
