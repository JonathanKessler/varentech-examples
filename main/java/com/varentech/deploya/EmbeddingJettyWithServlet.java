package com.varentech.deploya;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sun.corba.se.spi.activation.ServerHolder;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class EmbeddingJettyWithServlet {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/hello");
        server.setHandler(context);

        System.out.println("add servlets");
        context.addServlet(new ServletHolder(new HelloServlet()), "/*");
        context.addServlet(new ServletHolder(new FormServlet()), "/home");
        System.out.println("start server");
        server.start();
    }
    public static class HelloServlet extends HttpServlet {

        private static final long serialVersionUID = -6154475799000019575L;
        private static final String greeting = "Hello World";

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            //response.getWriter().println(greeting);
            System.out.println("in server 1");

            String username = request.getParameter("username");

            HttpSession session = request.getSession();
            session.setAttribute("Username", username);
            System.out.println(session.getAttribute("Username"));

            System.out.println("about to redirect");
            //request.getRequestDispatcher("link.html").include(request, response);
            response.sendRedirect("http://localhost:8080/hello/home");
            //request.getRequestDispatcher("GetName.html").include(request, response);
            System.out.println("should already redirect");

        }
    }

    public static class FormServlet extends HttpServlet {

        private static final long serialVersionUID = -6154475799000019575L;
        private static final String greeting = "Hello World";

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(greeting);

            System.out.println("enter server 2");


            System.out.println("redirect to html");
            //response.sendRedirect("C:\\Users\\kesslerk\\Documents\\UserName\\src\\main\\resources\\GetName.html");
            RequestDispatcher view = request.getRequestDispatcher("C:\\Users\\kesslerk\\Documents\\UserName\\src\\main\\resources\\GetName.html");
            view.forward(request, response);

            System.out.println("please");

            /*
            String username = request.getParameter("username");

            HttpSession session = request.getSession();
            session.setAttribute("Username", username);
            System.out.println(session.getAttribute("Username"));

            //request.getRequestDispatcher("link.html").include(request, response);
            response.sendRedirect("GetName.html");
            //request.getRequestDispatcher("GetName.html").include(request, response);
*/
        }
    }
}


