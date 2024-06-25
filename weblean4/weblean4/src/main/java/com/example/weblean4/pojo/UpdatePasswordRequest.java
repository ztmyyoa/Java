package com.example.weblean4.pojo;

public class UpdatePasswordRequest {
    private String userName;
    private String newPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UpdatePasswordRequest{" +
                "userName='" + userName + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
