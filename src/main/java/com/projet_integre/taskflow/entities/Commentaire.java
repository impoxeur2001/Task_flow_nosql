package com.projet_integre.taskflow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document("Commentaire")
@NoArgsConstructor @ToString
public class Commentaire {

    @Transient
    public static final String SEQUENCE_NAME = "commentaire_sequence";
    @Id

    private Integer id;
    private String contenu;
    @DBRef
    private Utilisateur auteur;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Commentaire(Integer id,String contenu, Utilisateur auteur) {
        this.id=id;
        this.contenu = contenu;
        this.auteur=auteur;
        this.date=new Date();
    }
}
