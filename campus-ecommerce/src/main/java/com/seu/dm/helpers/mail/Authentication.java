package com.seu.dm.helpers.mail;

import javax.mail.PasswordAuthentication;

/**
 * Created by 张老师 on 2017/3/13.
 */
public class Authentication extends javax.mail.Authenticator {
    String username=null;
    String password=null;

    public Authentication(){
    }
    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        PasswordAuthentication pa = new PasswordAuthentication(username, password);
        return pa;
    }
}
