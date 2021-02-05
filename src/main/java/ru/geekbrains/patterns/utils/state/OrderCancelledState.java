package ru.geekbrains.patterns.utils.state;

public class OrderCancelledState implements State {

    @Override
    public void cancel() {
        throw new RuntimeException("Заказ уже отменен!");
    }
}
