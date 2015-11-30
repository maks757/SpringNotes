package org.guts.model.form;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
public class RegisterUserForm {

    private String username;
    private String password;
    private String cpassword;

    public RegisterUserForm() {
    }

    public RegisterUserForm(String username, String password, String cpassword) {
        this.username = username;
        this.password = password;
        this.cpassword = cpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
}
