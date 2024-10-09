package org.devbank.devbankcredit.web.servlets;

import java.io.*;
import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.devbank.devbankcredit.model.entity.RequestStatuses;
import org.devbank.devbankcredit.model.entity.Status;
import org.devbank.devbankcredit.service.CreditRequestService;
import org.devbank.devbankcredit.service.StatusService;

@WebServlet(name = "HelloServlet", value = "/hello-servlet", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    @Inject
    private CreditRequestService creditRequestService;

    @Inject
    private StatusService statusService;

    @Inject
    private RequestStatuses requestStatuses;
    private String message;

    public void init() {
        System.out.println("initiated on load startup");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Initialize PrintWriter outside the loop
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>hey " + message + "</h1>");

            try {
                Optional<Status> creditRequests = statusService.findById(1);
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