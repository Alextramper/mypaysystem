package ru.krayPro.servlets;

import ru.krayPro.beans.Account;
import ru.krayPro.daos.AccountDAO;
import ru.krayPro.enums.AccountInfo;
import ru.krayPro.enums.ClientCredential;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки снятия средств
 */
@WebServlet (name = "withdrawal", urlPatterns = "/withdrawal")
public class WithdrawalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String sum = httpServletRequest.getParameter(AccountInfo.WITHDRAWAL_SUM.getAccountInfo());
        //TODO добавить валидацию суммы (положительные цифры)
        AccountDAO accountDAO = new AccountDAO();
        Account currentAccount = null;
        try {
            currentAccount = accountDAO.getById((Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential()));
        } catch (Exception e) {
            //TODO обработать исключения
        }
        //TODO добавить проверку на достаточность средств на счете
        currentAccount.setSum(currentAccount.getSum() - Integer.parseInt(sum));
        accountDAO.update(currentAccount);
    }
}
