package com.boutique.app.models.service;

import com.boutique.app.models.entity.CarService;
import com.boutique.app.models.entity.Client;

import javax.validation.Valid;
import java.util.List;

public interface ClientService {
    public Client clientCreate(String name,String type);
    public List<Client> clientList();
    public Client getClient(int id);

    public List<Client> findAll();

    public void save(@Valid Client client);

    Client findOne(int id);


}
