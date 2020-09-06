package ru.krayPro.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.krayPro.enums.Page;
import ru.krayPro.utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet(name = "logout", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletRequest.getSession().invalidate();
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.AUTH_PAGE.getPage());
    }
}
