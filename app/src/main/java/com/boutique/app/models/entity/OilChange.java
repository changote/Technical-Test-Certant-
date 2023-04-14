package com.boutique.app.models.entity;

import javax.persistence.*;

@Entity
public class OilChange extends CarService {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    ///basic or highPerformance
    private String type;

    ///diesel or gasoline
    private String carType;

    public OilChange(String type, String carType) {
        this.type = type;
        this.carType = carType;
    }

    public OilChange() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public void servicePrice(){
        switch (type){
            case "basic":
                price = 200d;
                break;
            case "highperformance":
                price = 300d;
                break;
            default:
                System.out.println("---------------------------------------------------------------------------fallo------------------------------------------------------------");
        }
        switch (carType){
            case "gasoline":
                price += 200d;
                break;
            case "diesel":
                price += 300d;
                break;
        }
    }

}
