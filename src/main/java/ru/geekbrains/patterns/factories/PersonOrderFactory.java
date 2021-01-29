package ru.geekbrains.patterns.factories;

import ru.geekbrains.patterns.entities.Client;
import ru.geekbrains.patterns.entities.OrderDTO;
import ru.geekbrains.patterns.entities.Person;
import ru.geekbrains.patterns.entities.PersonOrderDTO;

import java.time.LocalDate;

public class PersonOrderFactory implements AbstractOrderFactory{
    private static volatile PersonOrderFactory instance;
    private PersonOrderFactory(){}

    public synchronized static PersonOrderFactory getInstance() {
        if (instance == null) instance = new PersonOrderFactory();
        return instance;
    }

    @Override
    public OrderDTO createOrderDTO(Long id, Client person, String comment, LocalDate createDate) {
        if(!(person instanceof Person)) throw new RuntimeException("Incorrect client type!");
        return new PersonOrderDTO(id, ((Person)person).getClientName(), ((Person)person).getPhoneNumber(), comment, createDate);
    }
}
