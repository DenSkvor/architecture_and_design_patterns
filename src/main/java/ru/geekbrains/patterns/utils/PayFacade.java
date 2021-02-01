package ru.geekbrains.patterns.utils;

import ru.geekbrains.patterns.services.AccountService;
import ru.geekbrains.patterns.services.CheckService;
import ru.geekbrains.patterns.services.TransactionService;

public class PayFacade {

    private AccountService accountService;
    private CheckService checkService;
    private TransactionService transactionService;

    public PayFacade(){
        accountService = new AccountService();
        checkService = new CheckService();
        transactionService = new TransactionService();
    }

    public boolean pay(String client, double sum) {
        if(!checkService.checkClient(client)){
            System.out.println("Счёт заблокирован!");
            return false;
        }
        if(accountService.getAccountAmount(client) >= sum){
            transactionService.transferMoney(client, sum);
            return true;
        }
        System.out.println("Недостаточно средств!");
        return false;
    }
}

