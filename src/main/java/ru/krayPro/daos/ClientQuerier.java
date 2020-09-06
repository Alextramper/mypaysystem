package ru.krayPro.daos;

public class ClientQuerier {
    /**
     * SQL-запрос для вставки в БД информации о клинте
     */
    protected static final String INSERT_INTO_CLIENT_VALUES = "INSERT INTO PAYSYSTEM.PAYSYSTEM.CLIENT (LOGIN, PSSWD, FIRSTNAME, SECONDNAME, SURNAME, ACCOUNT_ID) VALUES (?,?,?,?,?,?)";

    /**
     * SQL-запрос для получения из БД информации о клиенте по логину и паролю
     */
    protected static final String SELECT_CLIENT_BY_LGN_AND_PSSWD = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.CLIENT WHERE LOGIN = ? AND PSSWD = ?";

    /**
     *  SQL-запрос для получения из БД информацию со списком всех клиентов
     */
    protected static final String SELECT_ALL_CLIENTS = "SELECT * FROM PAYSYTEM.PAYSYSTEM.CLIENT";
}
