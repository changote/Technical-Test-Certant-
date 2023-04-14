package com.boutique.app.models.service.imp;

import com.boutique.app.models.dao.IClientDao;
import com.boutique.app.models.dao.IServiceDao;
import com.boutique.app.models.dao.ITurnDao;
import com.boutique.app.models.entity.CarService;
import com.boutique.app.models.entity.Client;
import com.boutique.app.models.entity.Turn;
import com.boutique.app.models.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private IClientDao clientDao;

    @Autowired
    private IServiceDao serviceDao;

    @Override
    public Client clientCreate(String name, String type) {
        Client client = new Client();
        client.setName(name);
        client.setType(type);
        clientDao.save(client);
        return client;
    }

    @Override
    public List<Client> clientList() {
        return null;
    }

    @Override
    public Client getClient(int id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return (List<Client>) clientDao.findAll();
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findOne(int id){
        return clientDao.findById(id).orElse(null);
    }



}
