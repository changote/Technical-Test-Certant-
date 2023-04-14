package com.boutique.app.models.dao;

import com.boutique.app.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IClientDao extends CrudRepository<Client, Integer> {


}
