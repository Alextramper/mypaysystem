package ru.krayPro.enums;

/**
 * Перечисление, содержащие параметры из форм страниц
 */
public enum FormParameter {

    ENTER_PARAMETER("enter"),

    REG_PARAMETER("reg");

    private String formParameter;

    FormParameter(String formParameter) { this.formParameter = formParameter; }

    public String getFormParameter() { return formParameter; }

}
