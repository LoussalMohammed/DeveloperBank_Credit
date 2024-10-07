package org.devbank.devbankcredit.web.servlets;

import java.io.*;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.devbank.devbankcredit.model.entity.CreditRequest;
import org.devbank.devbankcredit.service.CreditRequestService;

@WebServlet(name = "HelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Inject
    private CreditRequestService creditRequestService;
    private String message;

    public void init() {
        message = "Hello Mohammed!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Initialize PrintWriter outside the loop
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>hey " + message + "</h1>");

            try {
                List<CreditRequest> creditRequests = creditRequestService.findAll();
                out.println("<p>by</p>");
                if (creditRequests.isEmpty()) {
                    out.println("<p>No credit requests found.</p>");
                } else {
                    out.println("<ul>");
                    out.println("<li>exists<l/i>");
                    out.println("</ul>");
                }
                out.println("<p>by</p></body></html>");
            } catch (Exception e) {
                out.println(e.getMessage()+"\n");
            } finally {
               out.println("end.");
            }


        } catch (IOException e) {
            // Handle IOException if needed
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }

    public void destroy() {
    }
}