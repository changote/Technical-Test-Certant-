package com.boutique.app.models.entity;




import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "clients")
@ToString
@EqualsAndHashCode


public class Client implements Serializable {

//    ///every client have an unique id for the map reference
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 4, max = 20)
    private String name;

    ///Premium if services are more than 5
    private String type;

    @OneToMany(mappedBy = "client", fetch = EAGER, cascade = CascadeType.ALL)
    private List<Turn> turnList;

    public Client() {
        turnList = new ArrayList<>();
    }

    @PrePersist
    public void basicClient(){
        type="Basic";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        clientType();
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(List<Turn> turnList) {
        this.turnList = turnList;
    }

    public void addTurn(Turn turn){
        this.turnList.add(turn);
    }

    public void clientType(){
        if(turnList.size() > 5)
            this.type = "Premium";
    }

    public String typeClient(){
        if(type.equals("Premium")){
            return "  10% de descuento!";
        }
        return "";
    }


}
