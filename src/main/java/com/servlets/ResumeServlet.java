package com.servlets;

import com.model.*;
import com.model.enums.ContactType;
import com.model.enums.SectionType;
import com.storage.SqlStorage;
import com.storage.collectionImpl.ListStorage;
import com.storage.interfaces.Storage;
import com.util.DateUtil;
import com.util.TestData;
import config.Config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Month;

public class ResumeServlet extends HttpServlet {

    private TestData testData;
    public ResumeServlet() {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
         testData = new TestData();
        super.init(config);

    }
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
            req.setAttribute("resumes", testData.getStorage().getAllSorted());
            req.getRequestDispatcher("WEB-INF/jsp/resumes.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello resumes");
        super.doPost(req, resp);
    }
}
