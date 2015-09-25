package com.parksmart

class UserService {

    User registerUser(RegisterCO registerCO){
        User user = User.getInstance(registerCO)
        user.save()
        user
    }

}
