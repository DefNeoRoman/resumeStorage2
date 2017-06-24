<%@ page import="com.model.enums.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="com.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form action="resume" method="post" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>
                имя
            </dt>
            <dd>
                <input type="text" name="fullName" value="${resume.fullName}">
            </dd>
        </dl>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <h3>Контакты</h3>
            <dl>
                <dt>
                    ${type.title}
                </dt>
                <dd>
                    <input type="text" name="${type.name()}" value="${resume.getContact(type)}" size="30">
                </dd>
            </dl>
        </c:forEach>
            <h3>
            секции
            </h3>
            </input type="text" name="section" value="1" size="30">
            </input type="text" name="section" value="1" size="30">
            </input type="text" name="section" value="1" size="30">
        </hr>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
   <jsp:include page="fragments/footer.jsp"/>
</body>
</html>
