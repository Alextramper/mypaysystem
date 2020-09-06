package ru.krayPro.enums;

/**
 * Перечисление, содержащее данные для счета
 */

public enum AccountInfo {

    ID("id"),

    ACCOUNT_NUMBER("account_number"),

    SUM("sum"),

    REPLENISH_SUM("replenish_sum"),

    WITHDRAWAL_SUM("withdrawal_sum");

    private String accountInfo;

    AccountInfo(String accountInfo) { this.accountInfo = accountInfo; }

    public String getAccountInfo() {return accountInfo; }
}
