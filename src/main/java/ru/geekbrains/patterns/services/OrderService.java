package ru.geekbrains.patterns.services;


import ru.geekbrains.patterns.factories.AbstractOrderFactory;
import ru.geekbrains.patterns.factories.CompanyOrderFactory;
import ru.geekbrains.patterns.factories.PersonOrderFactory;

public class OrderService {
    private static volatile OrderService instance;
    private OrderService(){}

    public synchronized static OrderService getInstance() {
        if (instance == null) instance = new OrderService();
        return instance;
    }

    enum OrderType{
        PERSON, COMPANY
    }

    public AbstractOrderFactory createFactory(OrderType orderType){
        if(orderType == OrderType.PERSON) return PersonOrderFactory.getInstance();
        if(orderType == OrderType.COMPANY) return CompanyOrderFactory.getInstance();
        return null;
    }

    public void createDelivery(AbstractOrderFactory factory){
        //factory.createOrderDTO(...) некая логика доставки...
    }
}
