package ru.geekbrains.patterns.entities;

import ru.geekbrains.patterns.utils.UnitOfWork;

public abstract class DomainObject {

    public abstract Long getId();

    public void markNew() {
        UnitOfWork.getCurrent().registerNew(this);
    }

    public void markDirty() {
        UnitOfWork.getCurrent().registerDirty(this);
    }

    public void markRemoved() {
        UnitOfWork.getCurrent().registerRemoved(this);
    }

}
