package ru.krayPro.enums;

/**
 * Перечисление, содержащее свойства подключения к БД
 */

public enum DbProperty {

    DRIVER_NAME_PROPERTY_NAME("driver_name"),

    URL_PROPERTY_NAME("url"),

    USER_PROPERTY_NAME("user"),

    PSSWD_PROPERTY_NAME("password");

    private String property;

    DbProperty(String property) { this.property = property; }

    public String getProperty() { return property; }

}
