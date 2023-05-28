package com.projet_integre.taskflow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("Utilisateur")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public class Utilisateur {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    public Integer getId() {
        return id;
    }

    @Id

    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String nom;

    private String email;

    public List<Tache> getTaches() {
        return taches;
    }

    @DBRef
    protected List<Tache> taches=new ArrayList<>();






    public Utilisateur(Integer id,String nom, String email){
        this.id=id;
        this.nom=nom;
        this.email=email;
    }

    public void quitterProjet(Projet projet){

        projet.getMembres().remove(this);
    }




    
    

}
