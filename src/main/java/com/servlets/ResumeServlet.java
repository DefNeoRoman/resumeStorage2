package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-type",  "text/html; charset=UTF-8");
        String parameterValue = req.getParameter("p");
        if (parameterValue == null || !parameterValue.equals("getAll"))
        {
            resp.getWriter().print("No resumes or wrong parameter. Parameter must be getAll");
        }
        else if (parameterValue.equals("getAll"))
        {
            resp.getWriter().print("<html>");
            resp.getWriter().print("<head>");
            resp.getWriter().print("<title>Таблица резюме</title>");
            resp.getWriter().print("</head>");
            resp.getWriter().print("<body>");
            resp.getWriter().print("<table border = 2>");
            resp.getWriter().print("<tr>");
            resp.getWriter().print("<td>UUID_ID</td>");
            resp.getWriter().print("<td>FULL_NAME</td>");
            resp.getWriter().print("<td>CONTACT_TYPE</td>");
            resp.getWriter().print("<td>CONTACT_VALUE</td>");
            resp.getWriter().print("</tr>");
            resp.getWriter().print("<tr>");
            resp.getWriter().print("<td>1</td>");
            resp.getWriter().print("<td>A</td>");
            resp.getWriter().print("<td>CT</td>");
            resp.getWriter().print("<td>CV</td>");
            resp.getWriter().print("</tr>");
            resp.getWriter().print("<table>");
            resp.getWriter().print("</table>");
            resp.getWriter().print("</body>");
            resp.getWriter().print("</html>");
        }}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello resumes");
        super.doPost(req, resp);
    }
}
