/*
 * @ (#) ControlServlet.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.GrantAccess;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.reImp.AccountRepository;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.services.Imp.AccountService;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.services.Imp.RoleService;

import java.io.IOException;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */

@WebServlet(name = "ControlServlet", urlPatterns = {"/control-servlet", "/control-servlet/*"})
public class ControlServlet extends HttpServlet {
    private static AccountService as = new AccountService();
    private static RoleService rs = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "LogIn": {
                String email = req.getParameter("email");
                String password = req.getParameter("password");

                Account a = as.checkLogin(email, password).orElse(null);

                if(a==null) {
                    req.setAttribute("message", "Login failed");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                } else {
                    if(rs.checkAdmin(a.getaccountId())){
                        req.setAttribute("message", null);
                        req.getServletContext().setAttribute("account", a);
                        req.getServletContext().setAttribute("accounts", as.selectAllAccount());
                        req.getRequestDispatcher("/page-for-admin.jsp").forward(req, resp);
                    }else{
                        req.setAttribute("message", null);
                        req.getServletContext().setAttribute("account", a);
                        req.getRequestDispatcher("/page-for-user.jsp").forward(req, resp);
                    }

                }
            }
        }
    }
}
