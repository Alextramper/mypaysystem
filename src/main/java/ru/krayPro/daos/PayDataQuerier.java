package ru.krayPro.daos;

public class PayDataQuerier {
    /**
     * SQL-querier for put pay information to DataBase
     */
    protected static final String INSERT_INTO_PAY_DATA_VALUES =
            "INSERT INTO PAYSYSTEM.PAYSYSTEM.PAY_DATA (CLIENT_ID, TARGET_ACCOUNT, SUM, DATE) VALUES(?,?,?,?)";

}
