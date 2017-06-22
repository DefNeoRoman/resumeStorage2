<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 22.06.2017
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandbox is working</h2>
<section>
    <table border="1" cellpadding="8" cellspacing="8">
        <tr>
            <th>Имя</th>
            <th>Email</th>
            <th></th>
            <th></th>
        </tr>


        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume"  type="com.model.Resume"/>
            <tr>
                <td><a href="sandbox?uuid=${resume.uuid}">${resume.fullName} </a></td>
                <td>${resume.uuid} </td>
                <td> <a href="sandbox?uuid=${resume.uuid}&action=edit">edit</a> </td>

                </tr>
        </c:forEach>

    </table>
    <jsp:useBean id="currUuid" scope="request" type="java.lang.String"/>
    <h3>${currUuid}</h3>
</section>
</body>
</html>
