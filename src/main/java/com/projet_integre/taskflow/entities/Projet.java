package com.projet_integre.taskflow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document("Projet")
@NoArgsConstructor @ToString
public class Projet {

    @Transient
    public static final String SEQUENCE_NAME = "projet_sequence";

    public void setId(Integer id) {
        this.id = id;
    }

    @Id

    private Integer id;
    private String nom;

    @DBRef
    private Utilisateur chef;

    public List<Utilisateur> getMembres() {
        return membres;
    }

    @DBRef
    protected List<Utilisateur> membres=new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date debut;

    public List<Tache> getTaches() {
        return taches;
    }

    @DBRef
    private List<Tache> taches=new ArrayList<>();



    public Projet(Integer id,String nom, Utilisateur chef) {
        this.id=id;
        this.nom = nom;
        this.chef = chef;
        this.debut=new Date();
    }



}
