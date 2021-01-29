package ru.geekbrains.patterns.entities;

public class Company implements Client{

    private final String clientName;
    private final Integer inn;
    private final String someImportantInfo;
    private final String phoneNumber;

    public String getClientName() {
        return clientName;
    }

    public Integer getInn() {
        return inn;
    }

    public String getSomeImportantInfo() {
        return someImportantInfo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Company(String clientName, Integer inn, String someImportantInfo, String phoneNumber) {
        this.clientName = clientName;
        this.inn = inn;
        this.someImportantInfo = someImportantInfo;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getInfo() {
        return "Company{" +
                "clientName='" + clientName + '\'' +
                ", inn=" + inn +
                ", someImportantInfo='" + someImportantInfo + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
