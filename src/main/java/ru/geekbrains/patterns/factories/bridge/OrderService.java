package ru.geekbrains.patterns.factories.bridge;


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


    public void createOrderTest(){
        //AbstractOrderFactory personOrderFactory new AbstractOrderFactoryImpl(new PersonOrderFactory());
        //personOrderFactory.createOrderDTO(...);

        //AbstractOrderFactory companyOrderFactory new AbstractOrderFactoryImpl(new CompanyOrderFactory());
        //companyOrderFactory.createOrderDTO(...);

    }
}
