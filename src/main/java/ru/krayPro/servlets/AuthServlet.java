package ru.krayPro.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.krayPro.beans.Client;
import ru.krayPro.daos.ClientDAO;
import ru.krayPro.enums.ClientCredential;
import ru.krayPro.enums.Page;
import ru.krayPro.exceptions.UnregistredAccountException;
import ru.krayPro.exceptions.UnregistredClientException;
import ru.krayPro.utils.ServletUtil;
import ru.krayPro.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Сервлет для аутентификации пользователя
 */
@Slf4j
@WebServlet(name="auth", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    /**
     * Метод обработки POST - запроса
     * @param httpServletRequest - запрос
     * @param httpServletResponse  ответ
     * @throws IOException ошибка перенаправления на другую страницу
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());
        ClientDAO clientDAO = new ClientDAO();
        Client client = null;
        try {
            client = clientDAO.get(clientLogin, clientPsswd);
            if(client == null) {
                //TODO вывести на GUI предупреждение "Проблемы с БД, обратитесь к администратору"
            }
        } catch (UnregistredClientException | UnregistredAccountException e) {
            log.error(e.getMessage());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_AUTH_PAGE.getPage());
    }
}
