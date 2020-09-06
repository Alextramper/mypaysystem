package ru.krayPro.exceptions;

public class PropertyReaderException extends Exception {

    public PropertyReaderException() { super(); }

    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public PropertyReaderException(String message) { super(message); }
}
