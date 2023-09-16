<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%--    <title>JSP - Hello World</title>--%>
</head>
<body>
    <form action="ControllerServlet" method="post">

        UserName  <input type="text" name="user"  >  <br>
        Password   <input type="password"  name="pass" > <br>

        <input type="submit" name="action" value="Login"></input>


        <input type="hidden" name="action" value="displayList">
    </form>



<%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>