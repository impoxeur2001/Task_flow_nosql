package com.projet_integre.taskflow.repositories;

import com.projet_integre.taskflow.entities.Projet;
import com.projet_integre.taskflow.entities.Tache;
import com.projet_integre.taskflow.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends MongoRepository<Tache, Integer> {
    public List<Tache> findByResponsable(Utilisateur responsable);
    public List<Tache> findTacheByProjet(Projet projet);
}
