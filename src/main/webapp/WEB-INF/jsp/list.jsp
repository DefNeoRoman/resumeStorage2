<%@ page import="com.model.enums.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../../css/fonts.css">
    <link rel="stylesheet" href="../../css/style.css">
     <title>Список всех резюме</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="container">
    <div>
        <section class="crudSection">
            <a class="resumeHref" href="resume?action=add">Create resume</a>
            <table class="crudTable">
                <tr>
                    <th>Имя</th>
                    <th>Контакты</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${resumes}" var="resume" >
                    <jsp:useBean id="resume" type="com.model.Resume"/>
                    <tr>
                        <td class="resumeTd">
                            <div class="forResumeHref">
                                <a class="resumeHref" href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a>
                            </div>
                        </td>
                        <td>
                            <p class="viewEmail">
                                <%=ContactType.EMAIL.toHtml(resume.getContact(ContactType.EMAIL))%><br>
                                <%=ContactType.SKYPE.toHtml(resume.getContact(ContactType.SKYPE))%>
                            </p>
                        </td>
                        <td class="resumeTd">
                            <div class="forResumeHref">
                                <a class="resumeHref" href="resume?uuid=${resume.uuid}&action=edit">Edit</a>
                            </div>
                        </td>
                        <td class="resumeTd">
                            <div class="forResumeHref">
                                <a class="resumeHref" href="resume?uuid=${resume.uuid}&action=delete">Delete</a>
                            </div>
                           </td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
