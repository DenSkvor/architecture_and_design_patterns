package ru.geekbrains.patterns.services;

import java.util.HashMap;

public class AccountService {

    private HashMap<String, Double> accountAmount;

    public AccountService(){
        accountAmount = new HashMap<String, Double>();
        accountAmount.put("Client1", 999.999);
    }

    //личный счет
    public double getAccountAmount(String client){
        return accountAmount.get(client);
    }
}
