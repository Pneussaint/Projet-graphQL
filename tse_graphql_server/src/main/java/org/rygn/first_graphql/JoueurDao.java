package org.rygn.first_graphql;

import java.util.List;
import java.util.stream.Collectors;

public class JoueurDao {

	private final List<Joueur> joueurs;

    public JoueurDao(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public List<Joueur> getJoueurs(int count, int offset) {
    	
    	return this.joueurs.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

	public Joueur saveJoueur(Joueur joueur) {
		
		this.joueurs.add(joueur);
		
		return joueur;
	}
}
