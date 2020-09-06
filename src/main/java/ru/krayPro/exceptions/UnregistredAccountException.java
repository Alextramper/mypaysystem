package ru.krayPro.exceptions;
/**
 * Исключение незарегистрированного счета
 */
public class UnregistredAccountException extends Exception {
    public UnregistredAccountException () { super(); }

    public UnregistredAccountException( String message) { super( message); }
}
