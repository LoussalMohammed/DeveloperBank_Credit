package org.devbank.devbankcredit.web.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.devbank.devbankcredit.exception.CustomValidationException;
import org.devbank.devbankcredit.model.entity.CreditRequest;
import org.devbank.devbankcredit.model.enums.CreditRequestStatus;
import org.devbank.devbankcredit.service.CreditRequestService;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@WebServlet("/creditRequest")
public class CreditRequestServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(CreditRequestServlet.class.getName());

    @Inject
    private CreditRequestService creditRequestService;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Received a POST request");
        System.out.println("Servlet POST method called");
        try {
            CreditRequest creditRequest = createCreditRequestFromParameters(request);
            System.out.println("here 1");
            creditRequestService.save(creditRequest);
            System.out.println("here 2");
            response.sendRedirect(request.getContextPath() + "/confirmation.jsp");
        } catch (CustomValidationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("here3");
    }

    private CreditRequest createCreditRequestFromParameters(HttpServletRequest request) {
        CreditRequest creditRequest = new CreditRequest();

        creditRequest.setProject(request.getParameter("projet"));
        creditRequest.setStatus(CreditRequestStatus.PENDING);
        creditRequest.setAmount(BigDecimal.valueOf(Long.parseLong(request.getParameter("montant"))));
        creditRequest.setDuration(Integer.parseInt(request.getParameter("duree")));
        creditRequest.setMonthlyPaymentsAmount(Double.parseDouble(request.getParameter("mensualites")));
        creditRequest.setEmail(request.getParameter("email"));
        creditRequest.setPhone(request.getParameter("telephone"));
        creditRequest.setCivility(request.getParameter("civilite"));
        creditRequest.setLastName(request.getParameter("nom"));
        creditRequest.setFirstName(request.getParameter("prenom"));
        creditRequest.setCin(request.getParameter("cin"));
        creditRequest.setBornDate(LocalDate.parse(request.getParameter("dateNaissance")));
        creditRequest.setStartDate(LocalDate.parse(request.getParameter("dateEmbauche")));
        creditRequest.setHasOngoingCredits("oui".equals(request.getParameter("creditEnCours")));
        creditRequest.setAcceptConditions(true);
        creditRequest.setJob(request.getParameter("status"));
        creditRequest.setTotalRevenue(BigDecimal.valueOf(Long.parseLong(request.getParameter("revenuMensuel"))));

        return creditRequest;
    }
}