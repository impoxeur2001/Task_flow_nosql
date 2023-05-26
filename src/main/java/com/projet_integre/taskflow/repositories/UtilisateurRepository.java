package com.projet_integre.taskflow.repositories;

import com.projet_integre.taskflow.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur, Integer> {
    public Utilisateur findByEmail(String email);

}
