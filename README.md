# tp-devmo-frigonnecte_erwan_eugene
tp-devmo-frigonnecte_erwan_eugene created by GitHub Classroom

## Fonctionnalités

L'application avait pour but de naviguer entre le frigo, avec la liste des ingrédients, le calendrier, avec les repas prévus, et les recettes. Les autres menus sont affichés dans la barre de navigation, mais ne sont pas accessibles.
Parmi ces menus, nous voulions simplement implémenter le calendrier, avec la possibilité de cliquer sur des repas pour choisir des recettes. L'utilisateur est alors redirigé vers la page recette où il peut choisir sa recette, valider, et être ramené sur la page du calendrier.
Les boutons "3 jours", "semaine", "10 jours" ne font rien pour le moment.

En résumé, les actions sont :
- cliquer sur le menu calendrier
- cliquer sur le deuxième ou troisième repas (le premier sert d'exemple pour montrer la mise à jour de l'affichage lors d'un choix de recette)
- cliquer sur une recette pour la choisir (cela affiche le repas choisi dans la console)
- cliquer sur le bouton valider (idéalement cette action aurait été fusionnée avec la précédente)

Cela ramène alors au menu calendrier, mais malheureusment rien ne s'affiche.

## Problèmes

Nous avons eu des problèmes avec les fragments afin de correctement les mettre en place et de naviguer entre eux avec la barre de navigation, mais cela fonctionne finalement à peu près comme il faut.

Par contre de nombreux problèmes sont survenus lors de l'utilisation de la base de données. Si la création de la liste des recettes se fait plutôt bien et permet de choisir une recette sur la page recette, la mise à jour de la base de données ne fonctionne pas bien, des erreurs de compilation surviennent au niveau de la requête UPDATE.
De plus, afin d'afficher le calendrier, nous effectuons une requête GET sur le calendrier pour récupérer les recettes associées à chaque repas, mais cette fois encore, nous avons eu des problèmes. Déjà, pour une raison inconnue, les recettes pour chaque jour sont toutes 'Poulet Frite' (cela provient sûrement du fait que la base de données n'est plus à jour, mais nous n'avons pas réussi à régler le problème). Aussi, au niveau de la classe TimeSlotRepository, une requête pour récupérer la recette associée à un repas est effectuée de manière asynchrone. Cela entraîne que la fonction renvoie null puisque la requête n'a pas encore pu être effectuée, et donc les données ne sont pas correctement récupérées par le calendrier.

Comme nous comptions utiliser la base de données pour communiquer entre les différents fragments, ces échecs font que ça ne fonctionne pas.

## Résultats

Nous avons réussi à naviguer entre les différents menus à l'aide de boutons, à changer l'affichage des menus (sous réserve qu'une bonne communication avec la base de données est été configurée) et finalement à implémenter une base de données et avoir un semblant de communication avec.
Mais il nous manque malheureusement des fonctions essentielles au bon fonctionnement de notre application, puisque nous ne pouvons pas faire grand chose avec notre base de données et que la communication entre nos fragments ne fonctionnent malheureusement pas.