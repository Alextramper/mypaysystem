package ru.krayPro.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.krayPro.beans.Account;
import ru.krayPro.beans.Client;
import ru.krayPro.daos.AccountDAO;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Сервлет для страницы регистрации
 */
@Slf4j
@WebServlet(name="regClient", urlPatterns ="/regClient")
public class RegClientServlet extends HttpServlet {

    /**
     * Метод обработки запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //TODO добавить выход из профиля
        //TODO доработать проброс на страницу ошибок
        Map<String, String> clientCredentials = SessionUtil.readClientCredentials(httpServletRequest);
        AccountDAO accountDAO = new AccountDAO();
        List<Account> allAccountNumbers = accountDAO.getAll();
        int accountNumber;
        Account currentAccount;
        do {
            accountNumber = ThreadLocalRandom.current().nextInt(10000, 99999);
            currentAccount = new Account(accountNumber);
        } while (allAccountNumbers.contains(currentAccount));
        accountDAO.insert(currentAccount);
        try {
            currentAccount = accountDAO.get(String.valueOf(accountNumber));
        } catch (Exception e) {
            log.error("Ошибка при попытке получить объект счета по номеру", + accountNumber);
            //TODO обработать исключение
        }
        //TODO добавить валидацию введенных данных пользователя
        Client client = new Client(
                clientCredentials.get(ClientCredential.LOGIN.getClientCredential()),
                clientCredentials.get(ClientCredential.PSSWD.getClientCredential()),
                clientCredentials.get(ClientCredential.FIRST_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SECOND_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SURNAME.getClientCredential()),
                currentAccount);
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(client);
        HttpSession httpSession = httpServletRequest.getSession();
        try {
            client = clientDAO.get(clientCredentials.get(ClientCredential.LOGIN.getClientCredential()),
                    clientCredentials.get(ClientCredential.PSSWD.getClientCredential()));
        } catch (UnregistredClientException | UnregistredAccountException e) {
            //TODO обработать исключение
        }
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_REG_PAGE.getPage());
    }
}
