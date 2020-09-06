package ru.krayPro.servlets;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) {
        System.out.println("Inside of the methods do Post in servlet IndexServlet");
    }
}
