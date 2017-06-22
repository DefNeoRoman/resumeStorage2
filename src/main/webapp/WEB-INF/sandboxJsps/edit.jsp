<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 22.06.2017
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="resume" scope="request" type="com.model.Resume"/>
<form method="post" action="sandbox?uuid=${resume.uuid}" enctype="application/x-www-form-urlencoded">
<tr>
    <td><input type="text" name="fullName" size=50 value="${resume.fullName}"></td>


    <td>${resume.uuid}</td>
    <button type="submit">Сохранить</button>
</tr>
</form>
</body>
</html>
