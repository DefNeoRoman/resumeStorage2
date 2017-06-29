<%@ page import="com.model.TextSection" %>
<%@ page import="com.model.ListSection" %>
<%@ page import="com.util.HtmlUtil" %>
<%@ page import="com.model.OrganizationSection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jstl/core" %>
<jsp:include page="fragments/header.jsp"/>
<body>

<section>
    <jsp:useBean id="resume" type="com.model.Resume" scope="request"/>
    <h2>
    ${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit">edit</a>
    </h2>
    <p>
        <c:forEach var="contactEntry" items="${resume.contacts}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<com.model.enums.ContactType, java.lang.String>"/>
            <c:set var="contact" value="${contactEntry.getKey().toHtml(contactEntry.getValue())}"/>
            <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>
        </c:forEach>
    </p>
</section>
<hr>
<table cellpadding="2">
    <c:forEach var="sectionEntry" items="${resume.sections}">
        <jsp:useBean id="sectionEntry"
                     type="java.util.Map.Entry<com.model.enums.SectionType, com.model.Section>"/>
        <c:set var="type" value="${sectionEntry.key}"/>
        <c:set var="section" value="${sectionEntry.value}"/>
        <jsp:useBean id="section" type="com.model.Section"/>
        <tr>
            <td><h3><a name="type.name">${type.title}</a></h3></td>
            <c:if test="${type=='OBJECTIVE'}">
                <td>
                    <h3><%=((TextSection) section).getContent()%></h3>
                </td>
            </c:if>
        </tr>
        <c:if test="${type!='OBJECTIVE'}">
            <c:choose>
                <c:when test="${type=='PERSONAL'}">
                    <tr>
                        <td>
                            <%=((TextSection) section).getContent()%>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                    <tr>
                        <td>
                            <ul>
                                <c:forEach var="item" items="<%=((ListSection) section).getItems()%>">
                                    <li>${item}</li>
                                </c:forEach>
                            </ul>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${type=='WORK_EXPERIENCE' || type=='EDUCATION'}">
                    <c:forEach var="org" items="<%=((OrganizationSection) section).getOrganizations()%>">
                        <tr>
                            <td>
                                <c:choose>
                                    <c:when test="${empty org.homePage.url}">
                                        <h3>${org.homePage}.url</h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3><a href="${org.homePage.url}">${org.homePage.name}</a></h3>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <c:forEach var="position" items="${org.positions}">
                            <jsp:useBean id="position" type="com.model.Organization.Position"/>
                            <tr>
                                <td><%=HtmlUtil.formatDates(position)%></td>
                                <td><b>${position.title}</b><br>${position.description}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:if>
    </c:forEach>
</table>
<button onclick="window.history.back()">OK</button>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>