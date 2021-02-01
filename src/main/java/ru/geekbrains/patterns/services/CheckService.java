package ru.geekbrains.patterns.services;

public class CheckService {

    public boolean checkClient(String client){
        //некая логика проверки валидности клиента...
        if(!client.isEmpty()) return true;
        return false;
    }
}
