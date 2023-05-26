package com.projet_integre.taskflow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document("Tache") @NoArgsConstructor  @ToString
public class Tache {

    @Transient
    public static final String SEQUENCE_NAME = "tache_sequence";
    @Id

    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date debut;

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    @Temporal(TemporalType.DATE)
    private Date deadLine;

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    private String titre;

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Integer getAvancement() {
        return avancement;
    }

    public void setAvancement(Integer avancement) {
        this.avancement = avancement;
    }

    private Integer avancement;

    public void setBreakPoints(List<Date> breakPoints) {
        this.breakPoints = breakPoints;
    }

    @Temporal(TemporalType.DATE)
    private List<Date> breakPoints=new ArrayList<Date>();

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }

    @DBRef
    private Utilisateur responsable;

    @DBRef
    private Projet projet;

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    @DBRef
    private List<Commentaire> commentaires;

    public void setEtat(EtatTache etat) {
        this.etat = etat;
    }

    @Enumerated(EnumType.STRING)
    private EtatTache etat;

    public Tache(Integer id,Date deadLine, String titre, Utilisateur responsable, Projet projet) {
        this.id=id;
        this.deadLine = deadLine;
        this.titre = titre;
        this.responsable = responsable;
        this.projet = projet;
        this.debut=new Date();
        this.avancement=0;
        this.breakPoints=new ArrayList<>();
        this.commentaires=new ArrayList<>();
        this.etat=EtatTache.En_ATTENTE;

    }
    public Tache(Integer id,Date deadLine, String titre, Utilisateur responsable, Projet projet,List<Date> breakPoints) {
        this.id=id;
        this.deadLine = deadLine;
        this.titre = titre;
        this.responsable = responsable;
        this.projet = projet;
        this.debut=new Date();
        this.avancement=0;
        this.breakPoints=breakPoints;
        this.commentaires=new ArrayList<>();
        this.etat=EtatTache.En_ATTENTE;

    }

}
