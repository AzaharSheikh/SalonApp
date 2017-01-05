package com.example.amitvarma.salonapp.model;

import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AmitVarma on 04-01-2017.
 */
public class User_Data_Model {
    String user_name,user_address,user_mobile,user_email,user_password;

    public User_Data_Model(String user_name, String user_address, String user_mobile, String user_email, String user_password) {
        this.user_name = user_name;
        this.user_address = user_address;
        this.user_mobile = user_mobile;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
