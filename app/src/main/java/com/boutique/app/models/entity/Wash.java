package com.boutique.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wash")
public class Wash extends CarService {
    ///Basic, complete or premium
    private String type;

    public Wash(double price, String description, String type) {

        this.type = type;
    }

    public Wash() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void servicePrice(){
        switch (type){
            case "basic":
                price = 100d;
                break;
            case "complete":
                price = 200d;
                break;
            case "premium":
                price = 300d;
                break;
        }
    }
}
