const { request, gql } = require('graphql-request');
 
const query = `
{
  joueurs(count: 11) {
    id
    nom
    prenom
    poste
  }
  equipes(count: 11) {
    id
    nom
  }
}
`;

request('http://localhost:8080/graphql', query)
    .then(
        (data) => {
            data.joueurs.forEach(element => {
              console.log(`Found Joueur #${element.id} named ${element.nom} ${element.prenom} playing as ${element.poste}!`);  
            });
            data.equipes.forEach(element => {
              console.log(`Found Equipe #${element.id} called ${element.nom} !`);  
            });
        });

