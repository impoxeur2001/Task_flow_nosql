package com.projet_integre.taskflow.repositories;

import com.projet_integre.taskflow.entities.ImageData;
import com.projet_integre.taskflow.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ImageDataRepository extends MongoRepository<ImageData, Integer> {
    Optional<ImageData> findByUtilisateur(Utilisateur utilisateur);

}
