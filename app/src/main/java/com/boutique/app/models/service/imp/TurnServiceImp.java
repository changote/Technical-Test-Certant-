package com.boutique.app.models.service.imp;

import com.boutique.app.models.dao.IServiceDao;
import com.boutique.app.models.dao.ITurnDao;
import com.boutique.app.models.entity.CarService;
import com.boutique.app.models.entity.Turn;
import com.boutique.app.models.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurnServiceImp implements TurnService {

    @Autowired
    private ITurnDao turnDao;

    @Autowired
    private IServiceDao serviceDao;

    @Override
    public Turn turnCreate(String plate, CarService serv) {
        Turn turn = new Turn();
        turn.setPlate(plate);
        turn.setService(serv);
        turnDao.save(turn);
        return turn;
    }

    @Override
    public List<Turn> turnList() {
        return null;
    }

    @Override
    public Turn getTurn(int id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Turn> findAll() {
        return (List<Turn>)turnDao.findAll();
    }

    @Override
    public void save(Turn turn) {
        turnDao.save(turn);
    }

    @Override
    @Transactional(readOnly = true)
    public Turn findOne(int id) {
        return turnDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public CarService findServiceById(int id) {
        return serviceDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveService(CarService service){
        serviceDao.save(service);
    }
}
