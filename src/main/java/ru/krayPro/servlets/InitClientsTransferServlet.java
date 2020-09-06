package ru.krayPro.servlets;

import ru.krayPro.beans.Client;
import ru.krayPro.daos.ClientDAO;
import ru.krayPro.enums.ClientCredential;
import ru.krayPro.enums.Page;
import ru.krayPro.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервлет для иницилизации элемента select
 */
@WebServlet(name = "initClientsTransfer", urlPatterns = "/initClientsTransfer")
public class InitClientsTransferServlet extends HttpServlet {

    /**
     * Метод обработки GET запросов
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> allClients = clientDAO.getAll();
        List<Client> clientWithoutCurrent = allClients.stream()
                .filter(x->x.getId() != (int) httpServletRequest.getSession()
                        .getAttribute(ClientCredential.ID.getClientCredential()))
                .collect(Collectors.toList());
        httpServletRequest.setAttribute("allClients", clientWithoutCurrent);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("views/tranfer.jsp");
        try {
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        } catch (IOException e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
