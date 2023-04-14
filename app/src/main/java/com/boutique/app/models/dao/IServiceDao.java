package com.boutique.app.models.dao;

import com.boutique.app.models.entity.CarService;
import org.springframework.data.repository.CrudRepository;

public interface IServiceDao extends CrudRepository<CarService,Integer> {
}
