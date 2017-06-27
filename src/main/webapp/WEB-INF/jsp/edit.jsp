<%@ page import="com.model.enums.ContactType" %>
<%@ page import="com.model.enums.SectionType" %>
<%@ page import="com.model.*" %>
<%@ page import="com.util.DateUtil" %>
<%@ page import="com.util.HtmlUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <jsp:useBean id="resume" type="com.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
ЭТО edit view
<jsp:include page="fragments/header.jsp"/>
<section>
    <form action="resume" method="post" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>
                <span class="input-group-addon" id="basic-addon1">Имя</span>
            </dt>
            <dd>
                <div class="input-group">
                    <input type="text" name="fullName" value="${resume.fullName}" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                </div>
              </dd>
        </dl>
        <h3>Контакты</h3>
        <c:forEach var="type" items="<%=ContactType.values()%>">
             <dl>
                <dt>
                    <span class="input-group-addon" id="basic-addon2">${type.title}</span>
                </dt>
                <dd>
                    <div class="input-group">
                        <input type="text" name="${type.name()}" value="${resume.getContact(type)}" class="form-control" placeholder="${type.title}" aria-describedby="basic-addon2">
                    </div>
                 </dd>
            </dl>
        </c:forEach>
        <c:forEach var="sectionEntry" items="${resume.sections}">
                <jsp:useBean id="sectionEntry" type="java.util.Map.Entry<com.model.enums.SectionType, com.model.Section>"/>
                <c:set var="type" value="${sectionEntry.key}"/>
                <c:set var="section" value="${sectionEntry.value}"/>
                <jsp:useBean id="section" type="com.model.Section"/>
                    <h3><a>${type.title}</a></h3></td>
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
                        </c:when>
                    </c:choose>
                </c:if>
            </c:forEach>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
   <jsp:include page="fragments/footer.jsp"/>
</body>
</html>
