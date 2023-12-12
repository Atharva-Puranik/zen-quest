package com.atharvapuranik.zenquest.login;


import org.springframework.stereotype.Service;

@Service
public class loginAuthenticationService {

    public boolean checkValidUser(String name, String password){
        boolean checkUname = name.equals("Atharva");
        boolean checkPass = password.equals("Atharva123");

        return checkUname && checkPass;
    }
}
