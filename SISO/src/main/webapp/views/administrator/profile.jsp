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
</div>
</body>
</html>
