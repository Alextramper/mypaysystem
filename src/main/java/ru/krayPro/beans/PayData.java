package ru.krayPro.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;


@AllArgsConstructor
@Data
@Getter
public class PayData {

    private Client client;
    private String targetAccount;
    private int sum;
    private Date date;


}
