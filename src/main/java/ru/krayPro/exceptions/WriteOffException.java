package ru.krayPro.exceptions;

/**
 * Исключение списания счета некорректной суммой
 */
public class WriteOffException extends Exception {

        /**
         * Конструктор без параметров
         */
        public WriteOffException() {
            super();
        }

        /**
         * Конструктор с информационным сообщением
         *
         * @param message информационное сообщение
         */
        public WriteOffException(String message) {
            super(message);
        }
}
