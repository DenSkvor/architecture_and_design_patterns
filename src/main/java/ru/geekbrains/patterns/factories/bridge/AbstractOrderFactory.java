package ru.geekbrains.patterns.factories.bridge;

import ru.geekbrains.patterns.entities.Client;
import ru.geekbrains.patterns.entities.OrderDTO;

import java.time.LocalDate;

public abstract class AbstractOrderFactory {

    protected OrderFactoryImpl implementor;

    public AbstractOrderFactory(OrderFactoryImpl implementor){
        this.implementor = implementor;
    }

    abstract OrderDTO createOrderDTO(Long id, Client client, String comment, LocalDate createDate);
}
