package ru.geekbrains.patterns.services;

public class TransactionService {

    public boolean transferMoney(String fromClient, double sum){
        //некая логика перевода денег...
        if(!(fromClient.isEmpty()) && sum > 0) return true;
        return false;
    }
}
