package ru.krayPro.exceptions;

/**
 * Исключение пополнения счета некорректной суммой
 */
public class ReplenishException extends Exception {

    /**
     * Конструктор без параметров
     */
    public ReplenishException() {super();}

    /**
     * Конструктор с сообщением
     * @param message информационное сообщение
     */
    public ReplenishException(String message) {
        super(message);
    }
}
