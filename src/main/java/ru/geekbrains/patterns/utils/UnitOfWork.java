package ru.geekbrains.patterns.utils;

import ru.geekbrains.patterns.entities.DomainObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitOfWork {

    private static ThreadLocal current = new ThreadLocal();

    public static void newCurrent() {
        setCurrent(new UnitOfWork());
    }

    public static void setCurrent(UnitOfWork unitOfWork) {
        current.set(unitOfWork);
    }

    public static UnitOfWork getCurrent() {
        return (UnitOfWork) current.get();
    }


    //кеш объектов домен-слоя
    private Map<Long, DomainObject> domainObjectMap = new HashMap();

    public static void addDomainObject(DomainObject object) {
        getCurrent().domainObjectMap.put(object.getId(), object);
    }

    public static void removeDomainObject(DomainObject object) {
        getCurrent().domainObjectMap.remove(object.getId());
    }

    public static DomainObject getDomainObject(Long key) {
        return getCurrent().domainObjectMap.get(key);
    }


    private List<DomainObject> newObjects = new ArrayList<>();
    private List<DomainObject> dirtyObjects = new ArrayList<>();
    private List<DomainObject> removedObjects = new ArrayList<>();

    public void registerNew(DomainObject object) {
        if (!newObjects.contains(object)) newObjects.add(object);
    }

    public void registerDirty(DomainObject object) {
        dirtyObjects.add(object);
    }

    public void registerRemoved(DomainObject object) {
        if (!removedObjects.contains(object)) {
            newObjects.remove(object);
            dirtyObjects.remove(object);
            removedObjects.add(object);
        }
    }

    public void commit() throws SQLException {
        insertNew();
        updateDirty();
        deleteRemoved();
    }

    private void insertNew() throws SQLException {
        for (DomainObject obj : newObjects) {
            DataMapperRegistry.getDomainObjectMapper(obj).insert(obj);
        }
    }

    private void updateDirty() throws SQLException {
        for (DomainObject obj : dirtyObjects) {
            DataMapperRegistry.getDomainObjectMapper(obj).update(obj);
        }
    }

    private void deleteRemoved() throws SQLException {
        for (DomainObject obj : removedObjects) {
            DataMapperRegistry.getDomainObjectMapper(obj).delete(obj);
        }
    }
}
