package com.saquapi.login;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class Login {

    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    String userName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
