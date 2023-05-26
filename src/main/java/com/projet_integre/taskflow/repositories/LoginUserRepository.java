package com.projet_integre.taskflow.repositories;

import com.projet_integre.taskflow.entities.LoginUser;
import com.projet_integre.taskflow.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends MongoRepository<LoginUser, String> {
}
