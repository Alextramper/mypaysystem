package ru.krayPro.daos;

public class AccountQuerier {

    /**
     * SQL-запрос для получения из БД информации о счете по идентификатору
     */
    protected static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM MYPAYSYSTEM.PAYSYSTEM.ACCOUNT WHERE ID = ?";

    /**
     * SQL-запрос для получения из БД информации о всех счетах
     */
    protected static final String SELECT_ALL_ACCOUNT_NUMBERS = "SELECT * FROM MYPAYSYSTEM.PAYSYSTEM.ACCOUNT";

    /**
     * SQL-запрос для получения из БД информации о счете по его номеру
     */
    protected static final String SELECT_ACCOUNT_BY_ACCOUNT_NUMBER = "SELECT * FROM MYPAYSYSTEM.PAYSYSTEM.ACCOUNT WHERE ACCOUNT_NUMBER = ?";

    /**
     * SQL-запрос для вставки в БД информации о счете
     */
    protected static final String INSERT_ACCOUNT_INFO = "INSERT INTO MYPAYSYSTEM.PAYSYSTEM.ACCOUNT (ACCOUNT_NUMBER) VALUES (?)";

    /**
     * SQL-запрос для обновления в БД информации о сумме на счете по идентификатору
     */
    protected static final String UPDATE_ACCOUNT_SUM = "UPDATE MYPAYSYSTEM.PAYSYSTEM.ACCOUNT SET SUM = ? WHERE ID = ?";

}
