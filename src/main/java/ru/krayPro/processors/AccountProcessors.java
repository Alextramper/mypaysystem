package ru.krayPro.processors;


import lombok.extern.slf4j.Slf4j;
import ru.krayPro.beans.Account;
import ru.krayPro.exceptions.ReplenishException;
import ru.krayPro.exceptions.WriteOffException;

/**
 * Класс, содержащий операции над счетами
 */
@Slf4j
public class AccountProcessors {

    private static void validateReplenishSum(int replenishSum) throws ReplenishException {
        log.info("Валидация суммы пополнения счета");
        if(replenishSum <= 0) {
            log.error("Ошибка при пополнении - сумма пополнения меньше 0");
            throw new ReplenishException("Сумма пополнения меньше 0.");
        }
    }

    private static void validateWriteOffSum(Account account, int writeOffSum) throws WriteOffException {
        log.info("Валидация суммы списания счета");
        if(writeOffSum > account.getSum()) {
            log.error("Ошибка при списании - недостаточно средств.");
            throw new WriteOffException("Недостаточно средств на счете.");
        }
    }

    /**
     * Метод пополнения счета
     *
     * @param account счет
     * @param replenishSum сумма пополнения
     * @return флаг пополнения счета
     */
    public static synchronized void replenishAccount(Account account, int replenishSum) throws ReplenishException {
        log.info(String.join(" ", "Пополнение счета", String.valueOf(account.getAccountNumber()),
                "на сумму", String.valueOf(replenishSum)));
        validateReplenishSum(replenishSum);
        account.setSum(account.getSum() + replenishSum);
        log.info(String.join(" ", "Пополнение счета",
                String.valueOf(account.getAccountNumber()), "прошло успешно. Текущая сумма на счете",
                String.valueOf(account.getSum())));
    }

    /**
     * Метод списания со счета
     *
     * @param account счет
     * @param writeOffSum сумма списания
     */
    //TODO написать тест к методу
    public static void withdrawalAccount(Account account, int writeOffSum) throws WriteOffException {
        log.info(String.join(" ", "Списание со счета", String.valueOf(account.getAccountNumber()),
                "на сумму", String.valueOf(writeOffSum)));
        validateWriteOffSum(account, writeOffSum);
        account.setSum(account.getSum() - writeOffSum);
        log.info(String.join(" ", "Списание со счета",
                String.valueOf(account.getId()), "прошло успешно. Текущая сумма на счете",
                String.valueOf(account.getSum())));
    }

    /**
     * Метод перевода со счета на счет
     *
     *@param fromAccount исходный счет
     *@param toAccount целевой счет
     *@param sum сумма
     */
    public static void transferMoney(Account fromAccount, Account toAccount, int sum)
            throws ReplenishException, WriteOffException {
        log.info(String.join(" ", "Перевод денег со счета",
                String.valueOf(fromAccount.getAccountNumber()), "на счет",
                String.valueOf(toAccount.getAccountNumber())));
        withdrawalAccount(fromAccount, sum);
        replenishAccount(toAccount, sum);
    }
}
