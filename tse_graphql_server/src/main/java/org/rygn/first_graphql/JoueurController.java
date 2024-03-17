package org.rygn.first_graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class JoueurController {

	@Autowired
	private JoueurDao joueurDao;

    @Autowired
    private EquipeDao equipeDao;

    @SchemaMapping(typeName = "Joueur", field = "equipe")
    public Equipe getEquipe(Joueur joueur) {
    	return this.equipeDao.getEquipeById(joueur.equipeId);
    }

    public JoueurController() {
    }

    @QueryMapping
    public List<Joueur> joueurs(@Argument int count, @Argument int offset) {
    	
        return this.joueurDao.getJoueurs(count, offset);
    }
    
    @MutationMapping
    public Joueur writeJoueur(@Argument String id, @Argument String nom, @Argument String prenom, @Argument String poste, @Argument String equipeId) {
    	
    	Joueur joueur = new Joueur();
    	joueur.setId(id);
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setPoste(poste);
        joueur.setEquipe(equipeId);
    	
        return joueurDao.saveJoueur(joueur);
    }
}
