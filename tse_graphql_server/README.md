# Projet GraphQL Serveur- Documentation

Ce projet implémente les classes Joueur et Equipe pour une application distribuée utilisant GraphQL.

## Classe Joueur

La classe Joueur représente un joueur dans notre application. Chaque joueur possède les attributs suivants :

- `id` : l'identifiant unique du joueur
- `nom` : le nom du joueur
- `prenom` : le prénom du joueur
- `poste` : le poste du joueur
- `equipeId` : l'identifiant de l'équipe à laquelle le joueur est lié (nullable)

## Classe Equipe

La classe Equipe représente une équipe dans notre application. Chaque équipe possède les attributs suivants :

- `id` : l'identifiant unique de l'équipe
- `nom` : le nom de l'équipe

## Jeux de données

Au démarrage de l'application, nous créons un jeu de 10 équipes et 10 joueurs. Les joueurs peuvent être liés à une équipe ou non, en utilisant le champ `equipeId` de la classe Joueur. Les équipes sont créées avec des noms génériques, tels que "Equipe 1", "Equipe 2", etc.

## Tests unitaires

J'ai inclus des tests unitaires pour vérifier le bon fonctionnement de l'application. Ces tests couvrent les fonctionnalités principales, telles que la création de joueurs et d'équipes, la liaison entre les joueurs et les équipes, etc. Vous pouvez exécuter ces tests pour vous assurer que tout fonctionne correctement. Les tests ont été découpés en deux partie, une partie joueurs et une partie équipes.
