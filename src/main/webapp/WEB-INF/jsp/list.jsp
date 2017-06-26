<%@ page import="com.model.enums.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/bootstrap-responsive.css">
    <link rel="stylesheet" href="../../css/custom-styles.css">
    <link rel="stylesheet" href="../../css/fonts.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/flexslider.css">
    <link rel="stylesheet" href="../../css/prettyPhoto.css">
    <link rel="stylesheet" href="../../css/style-ie.css">
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
                    <th>Email</th>
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
                                <%=ContactType.EMAIL.toHtml(resume.getContact(ContactType.EMAIL))%>
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
