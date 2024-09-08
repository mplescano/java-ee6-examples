package com.exie.web;

import com.exie.mjeedom.FlexService;
import com.exie.mjeedom.MyObject;
import org.w3c.dom.Document;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="flexservice", urlPatterns={"/flexservice"})
public class FlexServiceServlet extends HttpServlet {
    @EJB
    private FlexService delegate;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FlexServiceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet flexservice at " + request.getContextPath () + "</h1>");
            out.println("<p>get Object: " + delegate.getObject() + "</p>");
            out.println("<p>Save Object: " + delegate.saveObject(new MyObject()) + "</p>");
            out.println("<p>Ping: " + delegate.ping() + "</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
