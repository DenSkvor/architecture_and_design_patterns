package ru.geekbrains.patterns.repositories;

import ru.geekbrains.patterns.entities.DomainObject;
import ru.geekbrains.patterns.entities.OrderDTO;
import ru.geekbrains.patterns.entities.PersonOrderDTO;
import ru.geekbrains.patterns.utils.UnitOfWork;

import java.sql.*;

public class PersonOrderMapper implements DomainObjectMapper {

    private final Connection connection;

    public PersonOrderMapper(Connection connection) {
        this.connection = connection;
    }

    public PersonOrderDTO findById(long idPersonOrder) throws SQLException, IllegalArgumentException {
        //ищем объект в кеше
        PersonOrderDTO cashedPersonOrderDTO = (PersonOrderDTO) UnitOfWork.getDomainObject(idPersonOrder);
        if(cashedPersonOrderDTO != null) return cashedPersonOrderDTO;

        PreparedStatement ps = connection.prepareStatement(
                "SELECT order_id, client_name, phone_number, comment, date FROM person_order_tbl WHERE order_id = ?");
        ps.setLong(1, idPersonOrder);
        try (ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                PersonOrderDTO personOrderDTO = new PersonOrderDTO(
                        resultSet.getLong("order_id"),
                        resultSet.getString("client_name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("comment"),
                        resultSet.getDate("comment").toLocalDate()
                        );
                //добавляем в кеш
                UnitOfWork.addDomainObject(personOrderDTO);
                return personOrderDTO;
            }
        }
        throw new IllegalArgumentException("Заказ с указанным ID не найден - " + idPersonOrder);
    }


    public void insert(DomainObject personOrderDTO) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO person_order_tbl (client_name, phone_number, comment, date) VALUES (?,?,?,?);");
        ps.setString(1, ((PersonOrderDTO) personOrderDTO).getClientName());
        ps.setString(2, ((PersonOrderDTO) personOrderDTO).getPhoneNumber());
        ps.setString(3, ((PersonOrderDTO) personOrderDTO).getComment());
        ps.setDate(4, Date.valueOf(((PersonOrderDTO) personOrderDTO).getCreateDate()));
        ps.executeUpdate();
        //добавляем в кеш
        UnitOfWork.addDomainObject(personOrderDTO);
    }

    public void update(DomainObject personOrderDTO) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE person_order_tbl SET client_name = ?, phone_number = ?, comment = ?, date = ? WHERE order_id = ?);");
        ps.setString(1, ((PersonOrderDTO) personOrderDTO).getClientName());
        ps.setString(2, ((PersonOrderDTO) personOrderDTO).getPhoneNumber());
        ps.setString(3, ((PersonOrderDTO) personOrderDTO).getComment());
        ps.setDate(4, Date.valueOf(((PersonOrderDTO) personOrderDTO).getCreateDate()));
        ps.setLong(5, ((PersonOrderDTO) personOrderDTO).getId());
        ps.execute();
        //добавляем в кеш
        UnitOfWork.addDomainObject(personOrderDTO);
    }

    public void delete(DomainObject personOrderDTO) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM person_order_tbl WHERE order_id = ?;");
        ps.setLong(1, ((PersonOrderDTO) personOrderDTO).getId());
        ps.execute();
        //удаляем из кеша
        UnitOfWork.removeDomainObject(personOrderDTO);
    }
}

