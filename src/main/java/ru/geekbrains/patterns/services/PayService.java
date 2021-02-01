package ru.geekbrains.patterns.services;

import ru.geekbrains.patterns.utils.PayFacade;

public class PayService {

    //демонстрация фасада
    public void buyProducts(String client, Double cost){
        PayFacade pf = new PayFacade();
        pf.pay(client, cost);
    }
}
