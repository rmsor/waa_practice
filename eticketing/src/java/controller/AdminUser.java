/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author rmsor_000
 */
import java.io.Serializable;
import javax.inject.Named;
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
// or import javax.faces.bean.SessionScoped;

@Named("adminUser")
@SessionScoped
public class AdminUser implements Serializable {

    private String name;
    private String password;
    private Boolean isLoggedIn = false;

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }

    public String login() {
        if (name.equals("ram") && password.equals("shyam")) {
            isLoggedIn = true;
            return "dashboard";
        }else{
            return "pages/adminlogin";
        }
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public String logout() {
        isLoggedIn = false;
        return "login";
    }

    /* send to login page if they are not logged in */
    public void checkLogin(ComponentSystemEvent event) {

        if (!isLoggedIn) {

            FacesContext context = FacesContext.getCurrentInstance();

            ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();

            handler.performNavigation("pages/adminlogin");

        }

    }
}
