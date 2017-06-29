<%@ page import="com.model.enums.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-11">
            <a class="resumeHref" href="resume?action=add">
                Создать резюме
            </a>
        </div>
    </div>
               <div class="row">
                    <div class="col-md-3"><div class="resumeHref">Имя</div></div>
                    <div class="col-md-6"><div class="resumeHref">Контакты</div></div>
                </div>
                <jsp:useBean id="resumes" scope="request" type="java.util.List"/>
                <c:forEach items="${resumes}" var="resume" >
                    <jsp:useBean id="resume" type="com.model.Resume"/>
                    <div class="row">
                        <div class="col-md-3">
                           <a class="resumeHref" href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a>
                         </div>
                        <div class="col-md-6">
                            <p class="resumeHref">
                                <%=ContactType.EMAIL.toHtml(resume.getContact(ContactType.EMAIL))%><br>
                                <%=ContactType.SKYPE.toHtml(resume.getContact(ContactType.SKYPE))%>
                            </p>
                        </div>
                        <div class="col-md-1">
                          <a class="resumeHref" href="resume?uuid=${resume.uuid}&action=edit">Edit</a>
                        </div>
                        <div class="col-md-2">
                            <a class="resumeHref" href="resume?uuid=${resume.uuid}&action=delete">Delete</a>
                        </div>
                    </div>
            </c:forEach>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>

