/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.ajax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectItems;
import javax.faces.component.UISelectOne;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author 984317
 */
@Named("reg")
@RequestScoped
public class RegistrationBean {

    private List<User> userList;
    private User user;
    private static String COMPLETION_ITEMS_ATTR = "corejsf.completionItems";

    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationBean() {
        user = new User();
        userList = new ArrayList<>();
        userList.add(new User("John", "Doe", "ashokkafle@gmail.com", "1000 N 4TH ST", "IA", 51538));
        userList.add(new User("Shyam", "Ray", "Shyam@gmail.com", "104 W 8TH ST", "IL", 52593));
        userList.add(new User("Ankit", "Josh", "Ankit@gmail.com", "201 E 2ND ST", "IN", 42231));
        userList.add(new User("Suresh", "Manny", "Suresh@gmail.com", "932 E 2ND ST", "WA", 67231));
        userList.add(new User("Test", "Suresh", "Test@gmail.com", "802 E 2ND ST", "DW", 97423));
        userList.add(new User("Harish", "Harish", "Harish@gmail.com", "132 E 2ND ST", "CA", 23715));
        userList.add(new User("Feat", "Nepal", "Feat@gmail.com", "982 E 2ND ST", "TA", 19534));
        userList.add(new User("Jain", "Raj", "Jain@gmail.com", "1003 E 2ND ST", "WI", 38654));
        userList.add(new User("Hello", "Pokhrel", "Hello@gmail.com", "1132 E 2ND ST", "KN", 79821));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String submitForm() {
        return "result";
    }

    public void validateName(FacesContext fc, UIComponent c, Object value) {
        if (((String) value).matches(".*\\d+.*")) {
            throw new ValidatorException(new FacesMessage("Name cannot contain number"));
        }
    }

    public void valueChanged(ValueChangeEvent e) {
        UIInput input = (UIInput) e.getSource();
        UISelectOne listbox = (UISelectOne) input.findComponent("listbox");

        if (listbox != null) {
            UISelectItems items = (UISelectItems) listbox.getChildren().get(0);
            Map<String, Object> attrs = listbox.getAttributes();
            List<String> newItems = getNewItems((String) input.getValue(),
                    getCompletionItems(listbox, items, attrs));

            items.setValue(newItems.toArray());
            setListboxStyle(newItems.size(), attrs);
        }
    }

    private List<String> getNewItems(String inputValue, String[] completionItems) {
        List<String> newItems = new ArrayList<String>();

        for (String item : completionItems) {
            if (item.toLowerCase().startsWith(inputValue.toLowerCase())) {
                newItems.add(item);
            }
        }

        return newItems;
    }

    private void setListboxStyle(int rows, Map<String, Object> attrs) {
        if (rows > 0) {
            Map<String, String> reqParams = FacesContext.getCurrentInstance()
                    .getExternalContext().getRequestParameterMap();

            attrs.put("style", "display: inline; position: absolute; left: "
                    + reqParams.get("x") + "px;" + " top: " + reqParams.get("y") + "px");
        } else {
            attrs.put("style", "display: none;");
        }
    }

    private String[] getCompletionItems(UISelectOne listbox,
            UISelectItems items, Map<String, Object> attrs) {
        String[] completionItems = (String[]) attrs.get(COMPLETION_ITEMS_ATTR);

        if (completionItems == null) {
            completionItems = (String[]) items.getValue();
            attrs.put(COMPLETION_ITEMS_ATTR, completionItems);
        }
        return completionItems;
    }

    public void completionItemSelected(ValueChangeEvent e) {
        UISelectOne listbox = (UISelectOne) e.getSource();
        UIInput input = (UIInput) listbox.findComponent("regFname");

        if (input != null) {
            input.setValue(listbox.getValue());
        }
        Map<String, Object> attrs = listbox.getAttributes();
        attrs.put("style", "display: none");
        
        String fname = (String)listbox.getValue();
        for (User u : userList) {
            if (fname.equalsIgnoreCase(u.getfName())) {
                user.setEmail(u.getEmail());
                user.setState(u.getState());
                user.setStrtAddress(u.getStrtAddress());
                user.setlName(u.getlName());
                user.setZip(u.getZip());
            }
        }
    }

    public String[] completionItems() {
        String[] names = new String[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            names[i] = userList.get(i).getfName();
        }
        return names;
    }
}
