<%@ page import="vn.edu.iuh.fit.models.Account" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 15/09/2023
  Time: 2:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Profile</title>
</head>
<body>

    <p>Dang nhap Thanh Cong</p>
    <p>Thong tin Dang nhap</p>

    <%Account account = (Account) session.getAttribute("account");%>
    <p>Account_id: <%= account.getAccount_id() %></p>
    <p>Full_name: <%= account.getFull_name() %></p>
    <p>Password: <%= account.getPassword() %></p>
    <p>Phone: <%= account.getPhone() %></p>
    <p>Status: <%= account.getStatus() %></p>

</body>
</html>
