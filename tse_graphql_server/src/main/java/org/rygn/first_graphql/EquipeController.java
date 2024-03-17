package org.rygn.first_graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EquipeController {

	@Autowired
	private EquipeDao equipeDao;

    public EquipeController() {
    }

    @QueryMapping
    public List<Equipe> equipes(@Argument int count, @Argument int offset) {
    	
        return this.equipeDao.getEquipes(count, offset);
    }
    
    @MutationMapping
    public Equipe writeEquipe(@Argument String id, @Argument String nom) {
    	
    	Equipe equipe = new Equipe();
    	equipe.setId(id);
        equipe.setNom(nom);
    	
        return equipeDao.saveEquipe(equipe);
    }

    @MutationMapping
    public Equipe editEquipe(@Argument String id, @Argument String nom) {
    	
    	Equipe equipe = this.equipeDao.getEquipe(Integer.parseInt(id));
    	equipe.setId(id);
        equipe.setNom(nom);
    	
        return equipeDao.saveEquipe(equipe);
    }
}
