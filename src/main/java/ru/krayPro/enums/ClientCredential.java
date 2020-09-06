package ru.krayPro.enums;

/**
 * Перечисление, содержащее аутентификационные данные для клиента
 */
public enum ClientCredential {

    ID("id"),

    FIRST_NAME("firstname"),

    SECOND_NAME("secondname"),

    SURNAME("surname"),

    LOGIN("login"),

    PSSWD("psswd"),

    ACCOUNT_ID("account_id");

    private String clientCredential;

    ClientCredential (String clientCredential) { this.clientCredential = clientCredential; }

    public String getClientCredential() { return clientCredential; }

}
