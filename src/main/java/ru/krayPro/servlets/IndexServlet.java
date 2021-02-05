package ru.krayPro.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.krayPro.enums.FormParameter;
import ru.krayPro.enums.Page;
import ru.krayPro.utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для стартовой страницы
 */
@Slf4j
@WebServlet(name="index", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    /**
     * Метод для обработки запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * pageCommand
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String enterCommand = httpServletRequest.getParameter(FormParameter.ENTER_PARAMETER.getFormParameter());
        String regCommand = httpServletRequest.getParameter(FormParameter.REG_PARAMETER.getFormParameter());
        String pageCommand = Page.INDEX_PAGE.getPage();
        if(enterCommand != null) {
            pageCommand = Page.AUTH_PAGE.getPage();
        } else if(regCommand != null) {
            pageCommand = Page.REG_PAGE.getPage();
        }
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, pageCommand);
    }
}

