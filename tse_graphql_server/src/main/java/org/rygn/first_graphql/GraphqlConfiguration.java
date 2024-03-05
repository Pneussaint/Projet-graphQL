package org.rygn.first_graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

	@Bean
    public JoueurDao joueurDao() {
        List<Joueur> joueurs = new ArrayList<>();
        for (int joueurId = 0; joueurId < 10; ++joueurId) {
            Joueur joueur = new Joueur();
            joueur.setId("" + joueurId);
            joueur.setNom("Nom " + joueurId);
            joueur.setPrenom("Prenom " + joueurId);
            joueur.setPoste(joueurId % 2 == 0 ? "Attaquant" : "Defenseur");
            joueurs.add(joueur);
        }
        return new JoueurDao(joueurs);
    }	

	@Bean
    public EquipeDao equipeDao() {
        List<Equipe> equipes = new ArrayList<>();
        for (int equipeId = 0; equipeId < 10; ++equipeId) {
            Equipe equipe = new Equipe();
            equipe.setId("" + equipeId);
            equipe.setNom("Nom " + equipeId);
            equipes.add(equipe);
        }
        return new EquipeDao(equipes);
    }		
}
