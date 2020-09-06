package ru.krayPro.servlets;

import ru.krayPro.beans.Account;
import ru.krayPro.daos.AccountDAO;
import ru.krayPro.enums.AccountInfo;
import ru.krayPro.enums.ClientCredential;
import ru.krayPro.enums.Page;
import ru.krayPro.utils.ServletUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки пополнения счета
 */
public class ReplenishServlet extends HttpServlet {

    /**
     * Метод обработки запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String sum = httpServletRequest.getParameter(AccountInfo.REPLENISH_SUM.getAccountInfo());
        AccountDAO accountDAO = new AccountDAO();
        Account currentAccount = null;
        try {
            currentAccount = accountDAO.getById((Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential()));
        } catch (Exception e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
