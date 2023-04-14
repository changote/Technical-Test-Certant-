package com.boutique.app.models.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "aligment")
public class AligmentAndBalance extends CarService {
    ///Yes or not
    private Boolean tyreChange;

    public AligmentAndBalance(double price, String description, Boolean tyreChange) {

        this.tyreChange = tyreChange;
    }

    public AligmentAndBalance() {

    }

    public Boolean getTyreChange() {
        return tyreChange;
    }

    public void setTyreChange(Boolean tyreChange) {
        this.tyreChange = tyreChange;
    }

    @Override
    public void servicePrice(){
        price=200d;
        if(tyreChange){
            price += 1000d;
        }
    }
}
