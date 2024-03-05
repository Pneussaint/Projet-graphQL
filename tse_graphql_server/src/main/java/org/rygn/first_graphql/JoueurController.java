package org.rygn.first_graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class JoueurController {

	@Autowired
	private JoueurDao joueurDao;

    public JoueurController() {
    }

    @QueryMapping
    public List<Joueur> joueurs(@Argument int count, @Argument int offset) {
    	
        return this.joueurDao.getJoueurs(count, offset);
    }
    
    @MutationMapping
    public Joueur writeJoueur(@Argument String id, @Argument String nom, @Argument String prenom, @Argument String poste) {
    	
    	Joueur joueur = new Joueur();
    	joueur.setId(id);
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setPoste(poste);
    	
        return joueurDao.saveJoueur(joueur);
    }
}
