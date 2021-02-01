package ru.geekbrains.patterns.factories.bridge;

import ru.geekbrains.patterns.entities.Client;
import ru.geekbrains.patterns.entities.OrderDTO;

import java.time.LocalDate;

public interface OrderFactoryImpl {

    OrderDTO createOrderDTO(Long id, Client client, String comment, LocalDate createDate);
}
