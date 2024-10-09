<%@ page import="org.devbank.devbankcredit.web.servlets.CreditRequestServlet" %>
<%@ page import="org.devbank.devbankcredit.model.entity.CreditRequest" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mohammed-loussal
  Date: 10/8/24
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <table>
        <tr>
            <td>id</td>
            <td>civility</td>
            <td>first name</td>
            <td>last name</td>
            <td>cin</td>
            <td>born date</td>
            <td>job</td>
            <td>has onGoing credits</td>
            <td>project</td>
            <td>amount</td>
            <td>monthly payments</td>
            <td>start date</td>
            <td>total revenue</td>
            <td>status</td>

            <%
                List<CreditRequest> creditRequests = (List<CreditRequest>) request.getAttribute("creditRequests");
                for(CreditRequest creditRequest: creditRequests) {
            %>
            <td><%=creditRequest.getId()%></td>
            <td><%=creditRequest.getCivility()%></td>
            <td><%=creditRequest.getFirstName()%></td>
            <td><%=creditRequest.getLastName()%></td>
            <td><%=creditRequest.getCin()%></td>
            <td><%=creditRequest.getBornDate()%></td>
            <td><%=creditRequest.getJob()%></td>
            <td><%=creditRequest.getHasOnGoingCredits()%></td>
            <td><%=creditRequest.getProject()%></td>
            <td><%=creditRequest.getAmount()%></td>
            <td><%=creditRequest.getMonthlyPaymentsAmount()%></td>
            <td><%=creditRequest.getStartDate()%></td>
            <td><%=creditRequest.getTotalRevenue()%></td>
            <td><%=creditRequest.getStatus()%></td>
        </tr>
    </table>
</body>
</html>
