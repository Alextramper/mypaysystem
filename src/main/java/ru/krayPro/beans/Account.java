package ru.krayPro.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Account {
    private int id;
    private int accountNumber;
    private int sum;


    public Account(int accountNumber) {this.accountNumber = accountNumber;}

    @Override
    public boolean equals(Object object) {
        Account account = (Account) object;
        return this.accountNumber == account.getAccountNumber();
    }

    @Override
    public String toString() {return String.join("|", String.valueOf(sum));}

}
