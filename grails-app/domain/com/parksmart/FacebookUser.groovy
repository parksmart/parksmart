package com.parksmart

class FacebookUser {
    Long uid
    String accessToken
    Date accessTokenExpires
    User user

    static constraints = {
        uid unique: true
    }

    static mapWith = "mongo"
}