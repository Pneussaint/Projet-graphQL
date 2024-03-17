const { request, gql } = require('graphql-request');

const query = `
{
  joueurs(count: 11) {
    id
    nom
    prenom
    poste
    equipe {
      id
      nom
    }
  }
  equipes(count: 11) {
    id
    nom
  }
}
`;

const mutation = gql`
mutation mamutation{
  writeEquipe(id: "100", nom: "FC Barcelone") {
    id
    nom
  }
  writeJoueur(
    id: "111"
    nom: "test"
    prenom: "test"
    poste: "attaquant"
    equipeId:"0"
  ) {
    id
    nom
    prenom
    poste
    equipe {
      id
      nom
    }
  }
}
`;


request('http://localhost:8080/graphql', query)
  .then(
    (data) => {
      data.joueurs.forEach(element => {
        if (element.equipe != null)
          console.log(`Found Joueur #${element.id} named ${element.nom} ${element.prenom} playing as ${element.poste} in ${element.equipe.nom} !`);
        else
          console.log(`Found Joueur #${element.id} named ${element.nom} ${element.prenom} playing as ${element.poste} in no team !`);
      });
      data.equipes.forEach(element => {
        console.log(`Found Equipe #${element.id} called ${element.nom} !`);
      });
    });

request('http://localhost:8080/graphql', mutation)
  .then(
    (data) => {
      console.log(`Create Equipe #${data.writeEquipe.id} called ${data.writeEquipe.nom} !`);
      console.log(`Create Joueur #${data.writeJoueur.id} named ${data.writeJoueur.nom} ${data.writeJoueur.prenom} playing as ${data.writeJoueur.poste} in ${data.writeJoueur.equipe.nom} !`);
    });

