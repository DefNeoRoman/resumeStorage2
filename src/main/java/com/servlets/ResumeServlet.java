package com.servlets;

import com.model.Resume;
import com.storage.interfaces.Storage;
import config.Config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeServlet extends HttpServlet {
   private static Storage storage;
    static {

        storage = Config.getInstance().getStorage();
        try {
            storage.save(new Resume("uuid10"));
            storage.save(new Resume("uuid9"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p = req.getParameter("p");

        if (p.equals("getAll")) {
            req.setAttribute("resumes", storage.getAllSorted());
            req.getRequestDispatcher("../webapp/jsp/resumes.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello resumes");
        super.doPost(req, resp);
    }
}
