package ru.geekbrains.patterns.factories.bridge;

import ru.geekbrains.patterns.entities.Client;
import ru.geekbrains.patterns.entities.Company;
import ru.geekbrains.patterns.entities.CompanyOrderDTO;
import ru.geekbrains.patterns.entities.OrderDTO;

import java.time.LocalDate;

public class CompanyOrderFactory implements OrderFactoryImpl {


    @Override
    public OrderDTO createOrderDTO(Long id, Client company, String comment, LocalDate createDate) {
        if(!(company instanceof Company)) throw new RuntimeException("Incorrect client type!");
        return new CompanyOrderDTO(id, ((Company)company).getClientName(), ((Company)company).getInn(),
                ((Company)company).getSomeImportantInfo(), ((Company)company).getPhoneNumber(), comment, createDate);
    }
}
