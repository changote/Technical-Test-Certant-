package com.boutique.app.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "services")
@EqualsAndHashCode
public abstract class CarService {
    @Column(name = "service_price")
    protected double price;

    @Column(name = "service_description")
    private String description;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    public CarService() {
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void servicePrice(){

    }


}
