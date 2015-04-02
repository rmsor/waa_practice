/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545;

import helpers.RadioState;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 984317
 */
public class ChooseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatch = request.getRequestDispatcher("choose.jsp");

        dispatch.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String choice = request.getParameter("radioJSPCool");

        if (choice != null) {
            System.out.println("choice= " + choice);
        } else {
            System.out.println("No choice made");
        }
        /*--method 1---*/
        String radioJSPCool=((String)request.getParameter("radioJSPCool"));
        
        String yesCheck=radioJSPCool.equals("1")?"checked":"";
        String noCheck=radioJSPCool.equals("1")?"":"checked";
        request.setAttribute("yesCheckKey", yesCheck);
        request.setAttribute("noCheckKey", noCheck);
        
        /*---method 2-------*/
        String JSFwayCool=((String)request.getParameter("JSFwayCool"));
        RadioState rsObjCool=new RadioState();
        if(JSFwayCool.equals("1")){
            rsObjCool.setYesCheck("checked");
            rsObjCool.setNoCheck("");
        }else{
            rsObjCool.setYesCheck("");
            rsObjCool.setNoCheck("checked");
        }
        request.setAttribute("rsObjCool", rsObjCool);
        
        RequestDispatcher dispatch = request.getRequestDispatcher("choose.jsp");

        dispatch.forward(request, response);

    }

}
