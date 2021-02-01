package ru.geekbrains.patterns.factories.bridge;

import ru.geekbrains.patterns.entities.Client;
import ru.geekbrains.patterns.entities.OrderDTO;
import ru.geekbrains.patterns.entities.Person;
import ru.geekbrains.patterns.entities.PersonOrderDTO;

import java.time.LocalDate;

public class PersonOrderFactory implements OrderFactoryImpl {


    @Override
    public OrderDTO createOrderDTO(Long id, Client person, String comment, LocalDate createDate) {
        if(!(person instanceof Person)) throw new RuntimeException("Incorrect client type!");
        return new PersonOrderDTO(id, ((Person)person).getClientName(), ((Person)person).getPhoneNumber(), comment, createDate);
    }
}
