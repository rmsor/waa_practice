/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 984317
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/AjaxServlet"})

public class AjaxServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* Two ways to determine whether to handle date or temperature

         * String s;

         * 1.Look at the servlet path (e.g., date.ajax return date, temp.ajax return temperature

         *   s = request.getServletPath();

         * 2. Use getParameter by setting parameters in xhr.open

         *   Can add name/value pairs to the url argument of xhr.open

         *   xhr.open("POST", url+"?"+params, …  

         */
        response.setContentType("text/plain");

        response.setHeader("Cache-Control", "no-cache");

        response.setStatus(HttpServletResponse.SC_OK);
        
        String type=request.getParameter("type");
        if(type.equals("date"))
            response.getWriter().write(((new java.util.Date()).toString()));
        else
           response.getWriter().write("50C"); 

    }

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

}
