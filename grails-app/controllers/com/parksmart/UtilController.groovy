package com.parksmart

class UtilController {

    def userService

    def testRegistration(){
        RegisterCO registerCO = new RegisterCO(
                name:"manish",
                password: "igdefault",
                username: "manish@gmail.com",
                mobileNumber: "9910616296"
        )
        userService.registerUser(registerCO)
        render("DONE!!!")
    }


}
