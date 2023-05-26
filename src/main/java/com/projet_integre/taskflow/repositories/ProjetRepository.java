package com.projet_integre.taskflow.repositories;

import com.projet_integre.taskflow.entities.Projet;
import com.projet_integre.taskflow.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "projets", path = "projets")
public interface ProjetRepository extends MongoRepository<Projet, Integer> {
    public List<Projet> findProjetByChef_Id (Integer chefId);
    @Query("{'membres.$id': ?0}")
    List<Projet> findProjetByMemberId( Integer utilisateurId);






}
