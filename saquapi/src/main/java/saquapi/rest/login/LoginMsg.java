package saquapi.rest.login;

import javax.validation.constraints.NotNull;

public class LoginMsg {

    @NotNull
    int roomNumber;

    @NotNull
    String password;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginMsg{" +
                "roomNumber='" + roomNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
