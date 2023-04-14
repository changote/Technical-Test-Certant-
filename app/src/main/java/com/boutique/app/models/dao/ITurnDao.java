package com.boutique.app.models.dao;

import com.boutique.app.models.entity.Client;
import com.boutique.app.models.entity.Turn;
import org.springframework.data.repository.CrudRepository;

public interface ITurnDao extends CrudRepository<Turn, Integer> {
}
