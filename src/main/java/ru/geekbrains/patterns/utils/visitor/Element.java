package ru.geekbrains.patterns.utils.visitor;

public interface Element {

    void accept(Visitor visitor);
}
