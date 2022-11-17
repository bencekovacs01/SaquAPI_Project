package saquapi.rest.login;

import javax.validation.constraints.NotNull;

public class LoginMsg {

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
