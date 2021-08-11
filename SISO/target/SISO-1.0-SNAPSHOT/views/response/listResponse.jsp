<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 10/08/2021
  Time: 09:50 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
  <title>Lista de Respuestas</title>
</head>
<body>
<body>
<div class="container">
  <div class="row">
    <c:forEach items="${ listResponse }" var="response" varStatus="status">

      <form action="${context}/ServletResponse" method="POST" style="display: inline;">
        <input type="hidden" name="action" value="mostrar">
        <input type="hidden" name="id" value="${ response.id_response}">
        <button type="submit" class="btn"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/1200px-PDF_file_icon.svg.png" width="40" height="40"/> </button>
      </form>
    </c:forEach>
  </div>
</div>
</body>
</html>
