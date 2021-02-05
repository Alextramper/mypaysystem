package ru.krayPro.utils;

import lombok.extern.slf4j.Slf4j;
import ru.krayPro.enums.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Утилитный класс для сервлетов
 */
@Slf4j
public class ServletUtil {

    /**
     * Метод перенаправления из сервлетов на страницу
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @param pageCommand страница
     */
    public static void redirectInsideServlet(HttpServletRequest httpServletRequest,
                                             HttpServletResponse httpServletResponse, String pageCommand) {
        try {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + pageCommand);
        } catch (IOException e) {
            try {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Page.ERROR_PAGE);
            } catch (IOException e1) {
                log.error("Ошибка при попытке перенаправить на страницу с ошибкой", e1);
            }
        }
    }
}
