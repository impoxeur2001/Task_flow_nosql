package com.projet_integre.taskflow.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("imageData")

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {

    @Transient
    public static final String SEQUENCE_NAME = "image_sequence";

    public void setId(Integer id) {
        this.id = id;
    }

    @Id

    private Integer id;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Binary getImageData() {
        return imageData;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setType(String type) {
        this.type = type;
    }

    private String type;


    @DBRef
    private Utilisateur utilisateur;

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setImageData(Binary imageData) {
        this.imageData = imageData;
    }

    private Binary imageData;


}
