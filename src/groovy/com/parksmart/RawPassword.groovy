package com.parksmart

class RawPassword implements org.springframework.security.authentication.encoding.PasswordEncoder{
    public String encodePassword(String rawPass, Object salt) {
        return rawPass;
    }


    public boolean isPasswordValid(String encPass, String rawPass, Object saltIgnored) {
        return(encPass == rawPass)
    }
}