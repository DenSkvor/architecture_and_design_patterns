package ru.geekbrains.patterns.utils.state;

import ru.geekbrains.patterns.entities.OrderDTO;
import ru.geekbrains.patterns.entities.PersonOrderDTO;

public class OrderCompleteState implements State {

    private OrderDTO order;

    public OrderCompleteState(OrderDTO order) {
        this.order = order;
    }

    @Override
    public void cancel() {
        System.out.println("Заказ отменен.");
        ((PersonOrderDTO)order).setOrderState(new OrderCancelledState());
    }
}
