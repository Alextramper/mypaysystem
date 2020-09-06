package ru.krayPro.servlets;

import ru.krayPro.beans.Account;
import ru.krayPro.daos.AccountDAO;
import ru.krayPro.enums.ClientCredential;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки пополнения счета
 */
@WebServlet(name = "transfer", urlPatterns = "/transfer")
public class TransferServlet extends HttpServlet {

    /**
     * Метод обработки запроса
     * запрос
     * отввет
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        int fromClientAccountId = (Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential());
        int toClientAccountId = Integer.parseInt(httpServletRequest.getParameter("toClient"));
        int sum = Integer.parseInt(httpServletRequest.getParameter("tranferSum"));
        AccountDAO accountDAO = new AccountDAO();
        Account fromClientAccount = null;
        Account toClientAccount = null;
        try {
            fromClientAccount = accountDAO.getById(fromClientAccountId);
            toClientAccount = accountDAO.getById(toClientAccountId);
        } catch (Exception e) {
            //TODO обработать исключения
        }
        //TODO добавить проверку на достаточность средств на счете
        fromClientAccount.setSum(fromClientAccount.getSum() - sum);
        toClientAccount.setSum(toClientAccount.getSum() + sum);
        accountDAO.update(fromClientAccount);
        accountDAO.update(toClientAccount);
    }
}
