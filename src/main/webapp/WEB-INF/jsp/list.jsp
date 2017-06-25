<%@ page import="com.model.enums.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Список всех резюме</title>
</head>
<body>

<jsp:include page="fragments/header.jsp"/>
<section>
    <a href="resume?action=add">create Resumw</a>
    <table>
        <tr>
            <th>Имя</th>
            <th>Email</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${resumes}" var="resume" >
            <jsp:useBean id="resume" type="com.model.Resume"/>
            <tr>
                <td><a href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a></td>
                <td><%=ContactType.EMAIL.toHtml(resume.getContact(ContactType.EMAIL))%></td>
                <td><a href="resume?uuid=${resume.uuid}&action=edit">edit</a><img src="" alt="edit"></td>
                <td><a href="resume?uuid=${resume.uuid}&action=delete">delete</a><img src="" alt="delete"></td>
            </tr>
        </c:forEach>
    </table>
  </section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
