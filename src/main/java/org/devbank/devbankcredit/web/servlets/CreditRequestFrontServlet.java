package org.devbank.devbankcredit.web.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.devbank.devbankcredit.service.StatusService;

import java.io.IOException;

@WebServlet("/creditRequestFront")
public class CreditRequestFrontServlet extends HttpServlet {

    @Inject
    private StatusService creditRequestService;
    @Override
    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

        creditRequestService.findAll();

            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
