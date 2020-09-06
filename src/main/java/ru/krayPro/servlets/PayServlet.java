package ru.krayPro.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.krayPro.beans.Client;
import ru.krayPro.beans.PayData;
import ru.krayPro.daos.PayDataDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Сервлет для обработки оплаты
 */
@Slf4j
@WebServlet(name="pay", urlPatterns = "/pay")
public class PayServlet extends HttpServlet {

    /**
     *
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String payTargetCount = httpServletRequest.getParameter("payTargetCount");
        String paySum = httpServletRequest.getParameter("paySum");
        PayDataDAO payDataDAO = new PayDataDAO();
        //TODO
        Client client = new Client();
        client.setId(1);
        PayData payData = new PayData(client, payTargetCount, Integer.parseInt(paySum), new Date());
        payDataDAO.insert(payData);
    }
}
