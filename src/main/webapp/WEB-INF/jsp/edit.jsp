<%@ page import="com.model.enums.ContactType" %>
<%@ page import="com.model.enums.SectionType" %>
<%@ page import="com.model.*" %>
<%@ page import="com.util.DateUtil" %>
<%@ page import="com.util.HtmlUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>
<body>
<div class="container">
    <jsp:useBean id="resume" type="com.model.Resume" scope="request"/>
     <section>
        <form action="resume" method="post" enctype="application/x-www-form-urlencoded">
            <input type="hidden" name="uuid" value="${resume.uuid}">
            <div class="row">
                <div class="col-md-3">
                    <span class="input-group-addon" id="basic-addon1">Имя</span>
                </div>
                <div class="col-md-4">
                    <div class="input-group">
                        <input type="text" name="fullName" value="${resume.fullName}" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    </div>
                </div>
            </div>
            <h3>Контакты</h3>
            <c:forEach var="type" items="<%=ContactType.values()%>">
                <div class="row">
                    <div class="col-md-3">
                        <span class="input-group-addon" id="basic-addon2">${type.title}</span>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                        <input type="text" name="${type.name()}" value="${resume.getContact(type)}" class="form-control" placeholder="${type.title}" aria-describedby="basic-addon2">
                    </div>
                    </div>
                </div>
            </c:forEach>
            <c:forEach var="sectionEntry" items="${resume.sections}">
                <jsp:useBean id="sectionEntry" type="java.util.Map.Entry<com.model.enums.SectionType, com.model.Section>"/>
                <c:set var="type" value="${sectionEntry.key}"/>
                <c:set var="section" value="${sectionEntry.value}"/>
                <jsp:useBean id="section" type="com.model.Section"/>
                <div class="row">
                    <div class="col-md-3"><h3><a>${type.title}</a></h3></div>
                    <div class="col-md-4">
                        <c:if test="${type=='OBJECTIVE'}">
                            <input type="text" name="${type}" size="75" value="<%=((TextSection)section).getContent()%>">
                        </c:if>
                        <c:if test="${type!='OBJECTIVE'}">
                            <c:choose>
                                <c:when test="${type=='PERSONAL'}">
                                    <textarea name="${type}" cols="75" rows=5><%=((TextSection)section).getContent()%></textarea>
                                </c:when>
                                <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                                    <ul>
                                        <textarea name="${type}" cols="75" rows=5><%=String.join("\n", ((ListSection) section).getItems())%></textarea>
                                    </ul>
                                </c:when>
                                <c:when test="${type=='WORK_EXPERIENCE' || type=='EDUCATION'}">
                                    <c:forEach var="org" items="<%=((OrganizationSection) section).getOrganizations()%>" varStatus="counter">

                                        <dl>
                                            <dt>Название учреждения:</dt>
                                            <dd><input type="text" name='${type}' size="100" value="${org.homePage.name}"></dd>
                                        </dl>
                                        <dl>
                                            <dt>Сайт учреждения:</dt>
                                            <dd><input type="text" name='${type}url' size="100" value='${org.homePage.url}'></dd>
                                        </dl>
                                        <br>
                                        <div style="margin-left: 30px;">
                                            <c:forEach var="pos" items="${org.positions}">
                                                <jsp:useBean id="pos" type="com.model.Organization.Position"/>
                                                <dl>
                                                    <dt>Начальная дата:</dt>
                                                    <dd>
                                                        <input type="text" name='${type}${counter.index}startDate' size="10"value="<%=DateUtil.format(pos.getStartDate())%>" placeholder="MM/yyyy">
                                                    </dd>
                                                </dl>
                                                <dl>
                                                    <dt>Конечная дата:</dt>
                                                    <dd>
                                                        <input type="text" name='${type}${counter.index}endDate' size="10"
                                                               value="<%=DateUtil.format(pos.getEndDate())%>" placeholder="MM/yyyy">
                                                    </dd>
                                                </dl>
                                                <dl>
                                                    <dt>Должность:</dt>
                                                    <dd>
                                                        <input type="text" name='${type}${counter.index}title' size="75"
                                                               value="${pos.title}">
                                                    </dd>
                                                </dl>
                                                <dl>
                                                    <dt>Описание:</dt>
                                                    <dd>
                                        <textarea name='${type}${counter.index}description' rows="2"
                                                  cols="75">${pos.description}</textarea>
                                                    </dd>
                                                </dl>
                                            </c:forEach>
                                        </div>
                                    </c:forEach>

                                    <a href="resume?uuid=${resume.uuid}&action=addOrganization&orgType=${type}" class="btn-lg resumeHref" >Добавить ${type.title}</a>

                                    <br>
                                </c:when>
                            </c:choose>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
            <button type="submit">Сохранить</button>
            <button onclick="window.history.back()">Отменить</button>
        </form>
</div>
        <jsp:include page="fragments/footer.jsp"/>


</body>
</html>
