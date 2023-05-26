package com.projet_integre.taskflow.services;

import com.projet_integre.taskflow.entities.Projet;
import com.projet_integre.taskflow.entities.Utilisateur;
import com.projet_integre.taskflow.repositories.ProjetRepository;
import com.projet_integre.taskflow.repositories.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjetService implements IProjetService{
    @Autowired
    ProjetRepository pr;
    @Autowired
    UtilisateurRepository ur;
    @Override
    public Projet creerProjet(Integer id,String nom, Utilisateur chef) {
        Projet projet=new Projet(id,nom, chef);

        pr.insert(projet);
        return projet;

    }



    @Override
    public void supprimerProjet(Projet projet) {
        pr.delete(projet);
            }

    @Override
    public List<Projet> getProjetByChef(Utilisateur chef) {
        int chefId=chef.getId();

        return pr.findProjetByChef_Id(chefId);

    }

    @Override
    public List<Projet> getProjetByMember(Integer memberId) {
        return pr.findProjetByMemberId(memberId);
    }

    @Override
    public Optional<Projet> getProjetById(Integer id) {
        return pr.findById(id);
    }


}
