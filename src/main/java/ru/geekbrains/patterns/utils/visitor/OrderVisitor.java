package ru.geekbrains.patterns.utils.visitor;

import ru.geekbrains.patterns.entities.OrderDTO;

public class OrderVisitor implements Visitor {

    @Override
    public void visit(OrderDTO orderDTO) {
        //например некое логирование
        System.out.println(orderDTO.getOrderInfo());

    }
}
