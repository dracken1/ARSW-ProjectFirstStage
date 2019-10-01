package com.bloody.app.services.servlets;

import com.bloody.app.services.DBconnection.Bridge;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/autec")
public class LRservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Lusername");
        String password = request.getParameter("Lpassword");
        Bridge bg = new Bridge();
        if(bg.authentication(username,password)){
            request.getSession().setAttribute("name",username);
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("LoginRegistry.html");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("Rfname");
        String lastname = request.getParameter("Rlname");
        String username = request.getParameter("Rusername");
        String email = request.getParameter("Remail");
        String password = request.getParameter("Rpassword");
        Bridge bg = new Bridge();

        if(bg.addUser(firstname,lastname,username,email,password)){
            request.getSession().setAttribute("name",username);
            request.getRequestDispatcher("mainpage.jsp").forward(request,response);
        }
    }
}


