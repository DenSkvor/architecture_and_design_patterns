package ru.geekbrains.patterns.utils;

import ru.geekbrains.patterns.entities.DomainObject;
import ru.geekbrains.patterns.entities.PersonOrderDTO;
import ru.geekbrains.patterns.repositories.DomainObjectMapper;
import ru.geekbrains.patterns.repositories.PersonOrderMapper;

import java.sql.Connection;

public class DataMapperRegistry {

    private static DataMapperRegistry instance;
    private DataMapperRegistry(){}
    public static DataMapperRegistry getInstance(){
        if (instance == null) instance = new DataMapperRegistry();
        return instance;
    }

    private Connection connection;

    public static DomainObjectMapper getDomainObjectMapper(DomainObject object){
        if(object instanceof PersonOrderDTO) return new PersonOrderMapper(getInstance().connection);
        //...другие мапперы...

        throw new IllegalArgumentException("Неверный тип объекта - " + object.getClass() + "Должен быть - " + DomainObject.class);
    }
}
