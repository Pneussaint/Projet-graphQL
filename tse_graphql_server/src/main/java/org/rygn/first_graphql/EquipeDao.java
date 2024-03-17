package org.rygn.first_graphql;

import java.util.List;
import java.util.stream.Collectors;

public class EquipeDao {

	private final List<Equipe> equipes;

    public EquipeDao(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Equipe> getEquipes(int count, int offset) {
    	
    	return this.equipes.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public Equipe getEquipe(int id) {
    	
    	return this.equipes.get(id);
    }

    public Equipe getEquipeById(String id) {
        Equipe test = this.equipes.stream().filter(equipe -> equipe.id.equals(id)).findFirst().orElse(null);
    	return test;
    }

	public Equipe saveEquipe(Equipe equipe) {
		
		this.equipes.add(equipe);
		
		return equipe;
	}
}
