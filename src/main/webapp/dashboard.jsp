<%@ page import="vn.edu.iuh.fit.models.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 15/09/2023
  Time: 8:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
</head>
<body>
<style>
    table, th, td {
        border:1px solid black;
    }
    /* CSS để thiết lập các nút cân bằng */
    .balance-button {
        width: 100px;
        height: 40px;
        margin: 10px;
        font-size: 16px;
    }
</style>
    <h1> Bang du lieu admin dieu khien </h1>
    <table style="width:100% ">
        <thead>
        <tr>
            <th>Account_id</th>
            <th>Full_name</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Status</th>

        </tr>
        </thead>
        <tbody>

<%--        <c:forEach items="${accountList}" var="item">--%>
<%--            <tr>--%>
<%--                <td>${item.getAccount_id}</td>--%>
<%--                <td>${item.getFull_name}</td>--%>
<%--                <td>${item.getPassword}</td>--%>
<%--                <td>${item.getPhone}</td>--%>
<%--                <td>${item.getStatus}</td>--%>

<%--    --%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
    <%List<Account> accountList= (List<Account>) session.getAttribute("accountList");%>
        <% for (Account account : accountList) { %>
        <tr>
            <td><%= account.getAccount_id() %></td>
            <td><%= account.getFull_name() %></td>
            <td><%= account.getPassword() %></td>
            <td><%= account.getPhone() %></td>
            <td><%= account.getStatus() %></td>
        </tr>
        <% } %>

        </tbody>
        <tfoot>
        <!-- Nút cân bằng 1 -->
            <button class="balance-button" id="balance-button-1">Thêm </button>

            <!-- Nút cân bằng 2 -->
            <button class="balance-button" id="balance-button-2">Xóa </button>

            <!-- Nút cân bằng 3 -->
            <button class="balance-button" id="balance-button-3">Sửa</button>

            <!-- Nút cân bằng 4 -->
            <button class="balance-button" id="balance-button-4">Tiềm kiếm </button>
        </tfoot>
    </table>
</body>
</html>
