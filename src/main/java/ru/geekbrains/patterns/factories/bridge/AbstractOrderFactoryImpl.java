package ru.geekbrains.patterns.factories.bridge;

import ru.geekbrains.patterns.entities.Client;
import ru.geekbrains.patterns.entities.OrderDTO;

import java.time.LocalDate;

public class AbstractOrderFactoryImpl extends AbstractOrderFactory {

    public AbstractOrderFactoryImpl(OrderFactoryImpl implementor) {
        super(implementor);
    }

    @Override
    OrderDTO createOrderDTO(Long id, Client client, String comment, LocalDate createDate) {
        return implementor.createOrderDTO(id, client, comment, createDate);
    }
}
