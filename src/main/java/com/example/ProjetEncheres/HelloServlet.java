package com.example.ProjetEncheres;

import com.example.ProjetEncheres.bdd.Connect;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        try {
            Connection cnx = Connect.getConnection();
            String sql = "SELECT * FROM utilisateurs";
            Statement stmt = cnx.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            boolean encore = resultSet.next();
            while(encore) {
                String username = resultSet.getString("pseudo");
                System.out.println(username);
                encore = resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}