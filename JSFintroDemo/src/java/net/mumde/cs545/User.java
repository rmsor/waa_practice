/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mumde.cs545;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 984317
 */
import java.io.Serializable;

import javax.inject.Named;

import javax.enterprise.context.SessionScoped;


@Named("usr")

@SessionScoped

public class User implements Serializable

{

    private boolean bError = false;

    private String name;

    private String password;
    
    // value="#{user.name}"

    public String getName()

    {

        return name;

    }


    public void setName(String newValue)

    {

        name = newValue;

    }

    // value="#{user.password}"

    public String getPassword()

    {

        return password;

    }

    public void setPassword(String newValue)

    {

        password = newValue;

    }

 

    // rendered="#{user.error}"

    public boolean isError()

    {

        return bError;

    }

 

    // action="#{user.onLogin}"

    // As we shall see, the return value indicates what the next page will be

    public String onLogin()

    {

        bError = !password.equals("apple");

        if (bError)

            return "login";  // redisplay login.xhtml so that user can reenter the password

        else

            return "welcome";  // display welcome.xhtml

    }

}
