package com.example.secapp.user;

public enum Authorization {
    READ("READ"),
    WRITE("WRITE");

    private final String auth;

    Authorization(String auth) {
        this.auth = auth;
    }

    public String getAuth()
    {
        return auth;
    }
}
