<%@ page import="com.model.enums.SectionType" %>
<%@ page import="com.model.TextSection" %>
<%@ page import="com.model.ListSection" %>
<%@ page import="com.model.OrganizationSection" %>
<%@ page import="com.util.DateUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="resume" scope="request" type="com.model.Resume"/>
<form method="post" action="sandbox?uuid=${resume.uuid}&action=edit" enctype="application/x-www-form-urlencoded">
<tr>
    <td><input type="text" name="fullName" size=50 value="${resume.fullName}"></td>
    <td>${resume.uuid}</td>
    <c:forEach var="type" items="<%=SectionType.values()%>">
        <c:set var="section" value="${resume.getSection(type)}"/>
        <jsp:useBean id="section" type="com.model.Section"/>
        <h3><a>${type.title}</a></h3>
        <c:choose>
            <c:when test="${type=='OBJECTIVE'}">
                <input type="text" name="${type}" size="75" value="<%=((TextSection)section).getContent()%>">
            </c:when>
            <c:when test="${type=='PERSONAL'}">
                <textarea name="${type}" cols="75" rows=5><%=((TextSection)section).getContent()%></textarea>
            </c:when>
            <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                    <textarea name="${type}" cols="75"
                              rows=5><%=String.join("\n", ((ListSection) section).getItems())%></textarea>
            </c:when>
            <c:when test="${type=='WORK_EXPERIENCE' || type=='EDUCATION'}">
                <c:forEach var="org" items="<%=((OrganizationSection) section).getOrganizations()%>"
                           varStatus="counter">
                    <dl>
                        <dt>Название учреждения:</dt>
                        <dd><input type="text" name="${type}" size="100" value="${org.homePage.name}"></dd>
                    </dl>
                    <dl>
                        <dt>Сайт учреждения:</dt>
                        <dd><input type="text" name="${type}url" size="100" value="${org.homePage.url}"></dd>
                    </dl>
                    <br>
                    <div style="margin-left: 30px;">
                        <c:forEach var="pos" items="${org.positions}">
                            <jsp:useBean id="pos" type="com.model.Organization.Position"/>
                            <dl>
                                <dt>Начальная дата:</dt>
                                <dd>
                                    <input type="text" name="${type}${counter.index}startDate" size="10"
                                           value="<%=DateUtil.format(pos.getStartDate())%>" placeholder="MM/yyyy">
                                </dd>
                            </dl>
                            <dl>
                                <dt>Конечная дата:</dt>
                                <dd>
                                    <input type="text" name="${type}${counter.index}endDate" size="10"
                                           value="<%=DateUtil.format(pos.getEndDate())%>" placeholder="MM/yyyy">
                                </dd>
                            </dl>
                            <dl>
                                <dt>Должность:</dt>
                                <dd>
                                    <input type="text" name="${type}${counter.index}title" size="75"
                                           value="${pos.title}">
                                </dd>
                            </dl>
                            <dl>
                                <dt>Описание:</dt>
                                <dd>
                                        <textarea name="${type}${counter.index}description" rows="2"
                                                  cols="75">${pos.description}</textarea>
                                </dd>
                            </dl>
                        </c:forEach>
                    </div>
                </c:forEach>
            </c:when>
        </c:choose>
    </c:forEach>
    <button type="submit">Сохранить</button>
</tr>
</form>
</body>
</html>
