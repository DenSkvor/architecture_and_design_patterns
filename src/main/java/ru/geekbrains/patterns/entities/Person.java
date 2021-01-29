package ru.geekbrains.patterns.entities;

public class Person implements Client{

    private final String clientName;
    private final String phoneNumber;

    public String getClientName() {
        return clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person(String clientName, String phoneNumber) {
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getInfo() {
        return "Person{" +
                "clientName='" + clientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
