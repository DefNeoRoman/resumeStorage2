package com.servlets;

import com.model.Resume;
import com.storage.interfaces.Storage;
import config.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Пользователь on 22.06.2017.
 */
public class SandboxServlet extends HttpServlet {
    private Storage storage;
    @Override
    public void init() throws ServletException {
        storage = Config.getInstance().getStorage();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentUuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        Resume resume;
        if(action == null){
            action = "list";
        }
        if(action.equals("edit")){
         resume = storage.get(currentUuid);
         request.setAttribute("resume",resume);
         request.getRequestDispatcher("WEB-INF/sandboxJsps/edit.jsp").forward(request, response);
       return;
        }
        if(currentUuid == null){
            currentUuid = "nothing to show";
        }
        request.setAttribute("currUuid",currentUuid);
        request.setAttribute("resumes", storage.getAllSorted());
        request.getRequestDispatcher("WEB-INF/sandboxJsps/sandbox.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uuid = request.getParameter("uuid");
        String fullName = request.getParameter("fullName");
        Resume r = storage.get(uuid);
        r.setFullName(fullName);
        r.setUuid(uuid);
        storage.delete(uuid);
        storage.save(r);
        response.sendRedirect("sandbox");
    }

}
