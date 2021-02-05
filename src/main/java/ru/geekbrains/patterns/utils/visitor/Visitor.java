package ru.geekbrains.patterns.utils.visitor;

import ru.geekbrains.patterns.entities.OrderDTO;

public interface Visitor {
    void visit(OrderDTO orderDTO);
}
