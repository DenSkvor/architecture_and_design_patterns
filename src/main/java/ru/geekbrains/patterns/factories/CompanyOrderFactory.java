package ru.geekbrains.patterns.factories;

import ru.geekbrains.patterns.entities.Client;
import ru.geekbrains.patterns.entities.Company;
import ru.geekbrains.patterns.entities.CompanyOrderDTO;
import ru.geekbrains.patterns.entities.OrderDTO;

import java.time.LocalDate;

public class CompanyOrderFactory implements AbstractOrderFactory{
    private static volatile CompanyOrderFactory instance;
    private CompanyOrderFactory(){}

    public static synchronized CompanyOrderFactory getInstance(){
        if (instance == null) instance = new CompanyOrderFactory();
        return instance;
    }

    @Override
    public OrderDTO createOrderDTO(Long id, Client company, String comment, LocalDate createDate) {
        if(!(company instanceof Company)) throw new RuntimeException("Incorrect client type!");
        return new CompanyOrderDTO(id, ((Company)company).getClientName(), ((Company)company).getInn(),
                ((Company)company).getSomeImportantInfo(), ((Company)company).getPhoneNumber(), comment, createDate);
    }
}
