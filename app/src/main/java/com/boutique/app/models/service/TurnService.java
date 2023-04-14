package com.boutique.app.models.service;

import com.boutique.app.models.entity.CarService;
import com.boutique.app.models.entity.Turn;

import java.util.List;

public interface TurnService {
    public Turn turnCreate(String type, CarService serv);
    public List<Turn> turnList();
    public Turn getTurn(int id);

    public List<Turn> findAll();

    public void save(Turn turn);

    Turn findOne(int id);
    CarService findServiceById(int id);

    void saveService(CarService service);
}
