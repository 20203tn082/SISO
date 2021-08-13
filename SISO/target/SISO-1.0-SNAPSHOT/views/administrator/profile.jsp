<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 08/08/2021
  Time: 08:54 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
    <title>Perfil del administrador</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <span value="${beanAdministrator.nameAdmin}"></span>
        <input type="text" name="name" value="${beanAdministrator.nameAdmin}">
    </div>
    <div class="row">
        <span value="${beanAdministrator.passwordAdmin}"></span>
        <input type="text" name="password" value="${beanAdministrator.passwordAdmin}">
    </div>
    <div class="row">
        <form action="${context}/ServletAdministrator" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="username" value="${beanAdministrator.nameAdmin}">
            <label>Nombre de usuario:</label>
            <input type="text" name="name" value="${beanAdministrator.nameAdmin}">
            <label>Contraseña:</label>
            <input type="password" name="password" value="${beanAdministrator.passwordAdmin}">
            <button type="submit">Modificar</button>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</body>
</html>
