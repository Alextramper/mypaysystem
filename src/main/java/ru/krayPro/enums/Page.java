package ru.krayPro.enums;

/**
 * Перечисление, содержащие страницы для навигации
 */
public enum Page {

    INDEX_PAGE("index.jsp"),

    REG_PAGE("/views/registration.jsp"),

    SUCCESS_REG_PAGE("/views/successRegClient.jsp"),

    AUTH_PAGE("/views/auth.jsp"),

    SUCCESS_AUTH_PAGE("/views/succesAuthClient.jsp"),

    ERROR_PAGE("/views/error.jsp");

    private String page;

    Page (String page) { this.page = page; }

    public String getPage() { return page; }

}
