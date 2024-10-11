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
    <!--- Css Style Links --->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <table>
        <thead class="table-header">
            <th>civility</th>
            <th>name</th>
            <th>cin</th>
            <th>born date</th>
            <th>job</th>
            <th>Have credits</th>
            <th>project</th>
            <th>amount</th>
            <th>monthly payments</th>
            <th>start date</th>
            <th>total revenue</th>
            <th>status</th>
            <th>Edit</th>
        </thead>

            <%
                List<CreditRequest> creditRequests = (List<CreditRequest>) request.getAttribute("creditRequests");
                for(CreditRequest creditRequest: creditRequests) {
            %>
        <tr>
            <td><%=creditRequest.getCivility()%></td>
            <td><%=creditRequest.getFirstName()+" "+creditRequest.getLastName()%></td>
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
            <td>
                <form action="${pageContext.request.contextPath}/admin" method="post">
                    <input type="hidden" name="id" value="<%=creditRequest.getId()%>">
                    <button id="edit-btn" type="submit">edit</button>
                </form>
                </td>
        </tr>

        <% } %>
    </table>
</body>
</html>
