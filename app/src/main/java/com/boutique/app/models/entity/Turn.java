package com.boutique.app.models.entity;

import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "turns")
@EqualsAndHashCode
public class Turn {
    @NotNull
    @Temporal(TemporalType.DATE)
    @Future
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date date;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    ///AAA111 format
    @NotEmpty
    @Column(name="plate")
    @Pattern(regexp="^([a-zA-Z]{2}[0-9]{3}[a-zA-Z]{2})|^([a-zA-Z]{3}[0-9]{3})")
    private String plate;

    @OneToOne
    private CarService service;

    @ManyToOne(fetch = EAGER)
    private Client client;

    public Turn() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    ///if the client is premium, apply 10% discount
    public double getServiceTotalPrice(){
        if(client.getType().equals("Premium")){
            return service.getPrice()*0.9;
        }
        return service.getPrice();
    }

    public CarService getService() {
        return service;
    }

    public void setService(CarService service) {
        this.service = service;
    }

    public String getInstanceService(){
        if(service instanceof OilChange)
            return "Cambio de aceite";
        if(service instanceof AligmentAndBalance)
            return "Alineacion y balanceo";
        if(service instanceof Wash)
            return "Lavado";
        return null;
    }

}
