# Question pour un Bouffon
Projet POO en Java
Jeu de Questions / Réponses

Dates importantes : 

    Semaine du 06/12/2021 :
        2ème dépôt du code le 5/12/2021 avant minuit 
        Soutenance du projet avec temps de parole équitable parmi tous les membres d’une équipe.
        Exécution de tests significatifs
        Chaque membre d’une équipe doit s’être approprié l’intégralité du code rendu 
    Semaine du 13/12/2021
        3ème dépôt du code et du rapport le 17 décembre avant 20h

Cahier des charges

    Objectif : Implémenter un jeu de Questions / Réponses entre au moins 4 joueurs au début du jeu.

    Système :
        1 phase de jeu -> 1 élimination 
        Total de n-1 phases de jeu (n>=4 -> nombre de joueurs)

    Jeu de base → Liste de questions réponses
    Les participants répondent à tour de rôle
    En fonction des réponses : score cumulé par joueur et les participants avec les meilleurs scores sont sélectionnés pour les phases suivantes.

---------- PREMIERE PARTIE ----------

I - Question

    H thèmes avec H>=10
    3 types :
        QCM (1 seule réponse entre plusieurs)
        VF (uniquement vrai ou faux)
        RC (le joueur peut saisir une réponse courte)
    3 niveaux de difficulté :
        1 (niveau facile)
        2 (niveau moyen)
        3 (niveau difficile)

II - Classes des types questions

    Type QCM :
        1 texte
        3 variables réponses
        1 variabe bonne réponse
    Type VF :
        1 texte
        1 bonne réponse (type booléen)
    Type RC :
        1 texte
        1 variable bonne réponse (type String)
        
    Les questions sont numérotées de manière séquentielle indépendamment de leurs thèmes.
    
Donner l'implémentation des questions :

    Pour chaque question :
        1 constructeur
        1 méthode qui retourne une représentation textuelle d'une question (thème, numéro, niveau, énoncé, réponse en fonction du type)
        1 méthode de saisie qui permet la saisie d'une question d'un type donné

III - Thèmes

    - Désigné par 1 chaîne de caractères (Science, Sport, Histoire...)
    - Au moins 10 thèmes différents
    - Lorsqu'un thème est sélectionné, un indicateur est positionné sur ce thème : IMPOSSIBLE à choisir pour la prochaine sélection
    
Implémentation de la classe Themes :

    1 constructeur
    1 méthode de sélection d'un thème (demande à l'utilisateur un thème et renvoie son indice)
    1 méthode de sélection de cinq thèmes
    1 méthode qui retourne une représentation textuelle de tous les thèmes et la valeur de leur indicateur

IV - Questions

    - Pour chaque thème : 1 ensemble de questions dont le nombre et les types sont variable
    - L'ensemble des questions relatives à 1 thème est stocké dans une liste chaînée de questions
    - A chaque fois, un indicateur de la question sélectionnée est mis à jour
    - Le nombre de question de chaque thème est donné aléatoirement entre 5 et 10

Implémentation de la classe Questions :

    1 constructeur
    1 méthode d'ajout d'une question
    1 méthode de supression d'une question par con rang dans la liste
    1 (ou +) méthode(s) de sélection d'une question qui sélectionne une question pour un joueur selon une politique qui sera définie dans les différentes phases du jeu
    1 méthode qui retourne une représentation textuelle de tous les thèmes et de leurs questions

V - Phase

    Une partie -> Plusieurs phase
    A chaque phase : 
        le joueur ayant le plus faible score est éliminé
        les autres sont sélectionnés pour la phase suivante
    
    Définir une interface Phase comportant :
        1 méthode permettant de sélectionner des joueurs
        1 méthode permettant de dérouler une phase de jeu
    #Il est possible d'ajouter toute autre classe jugée nécessaire pour implémenter une partie du jeu à partir de l'interface Phase

VI - Joueur

    - 1 joueur = 1 numéro, 1 nom, 1 score et 1 état (gagnant, super gagnant, éliminé ou en attente)
    - Numéro du 1er joueur = 100, incrémenter de 10 à chaque nouveau joueur
    - 1 réponse correcte -> Score incrémenté d'une valeur dépendant de la phase du jeu

Implémentation de la classe Joueur :

    1 constructeur
    1 méthode de saisie
    1 méthode qui retourne une représentation textuelle
    1 méthode de mise à jour du score
    1 méthode de changement de l’état

VII - Joueurs

    Ensemble des joueurs stocké dans un tableau de 20 joueurs candidat (dont au moins 4 pourront participer au jeu)

Implémentation de la classe Joueurs :

    1 constructeur
    1 méthode de sélection aléatoire d’un joueur du tableau
    1 méthode générant aléatoirement l’ensemble des joueurs
    1 méthode qui retourne une représentation textuelle de l’ensemble des joueurs participant au jeu

Remarques :

    - Pour des besoins de tests, il faut prévoir à l’intérieur des classes des constructeurs supplémentaires permettant de remplir par programme les structures nécessaires au déroulement du test afin d’éviter la saisie de données longue et fastidieuse.
    - Il faudra remplir avec des données correctes et sensées.
    - Pour les noms des joueurs, utiliser les lettres de l’alphabet A, B, C, …, Z.
    - S’il y a lieu, surcharger et/ou redéfinir les méthodes et/ou créer des sousclasses.

---------- DEUXIEME PARTIE ----------

Application à réaliser - Phases du jeu

Le jeu de Questions / Réponses à réaliser comprendra trois phases où 4 joueurs s’affrontent autour de questions sur 10 thèmes: 

I - Phase 1

    - 4 joueurs choisis aléatoirement
    - 1 thème parmi 10 est sélectionné automatiquement du tableau dans un ordre séquentiel (un indicateur du dernier thème sélectionné est mis à jour, après le choix du 10ème thème, on revient au premier)
    - 1 question de niveau facile est sélectionnée pour chacun des joueurs selon une politique de Round-Robin
    - Les 4 joueurs répondent à leurs questions séparément -> score incrémenté de 2 si la réponse est correcte

II - Phase 2

    - 3 joueurs gagnants de la phase 1
    - 2 questions de niveau moyen pour chaque joueur (1 question par thème choisi)
    - A tour de rôle et de manière alternée, chaque joueur choisit un thème parmi SEULEMENT 6 thèmes choisis aléatoirement (ce n'est plus 10 thème) ensuite au deuxième ... qui est supprimé des choix aussitôt sélectionnés
    - 1 question de niveau moyen (dans le thème choisi) est sélectionné selon la politique RR et présentée au joueur
    - Le score du joueur qui donne la bonne réponse est incrémenté de 3

III - Phase 3

    - 2 joueurs gagnants de la phase 2
    - Les deux questions de niveau difficile porteront sur trois thèmes choisis par le concepteur du jeu
    - 1 question de niveau difficile (dans le thème choisi) est sélectionnée selon la politique de RR et présentée au joueur
    - Le score du joueur donnant la bonne réponse est incrémenté de 5

Description de l'application

    L'application doit permettre de réaliser les actions suivantes :

    - Afficher les 10 thèmes choisis
    - Créer une liste de questions pour chaque thème
    - Afficher toutes les questions d’un niveau n donné par thème
    - Ajouter une question à la liste pour un thème donné
    - Supprimer une question de numéro n de la liste pour un thème donné
    - Créer le tableau de joueurs et afficher leurs états
    - Lancer une partie du jeu avec 4 joueurs choisis en affichant toutes les étapes du déroulement du jeu
    - Quitter le jeu
    - D’autres actions peuvent être ajoutées si nécessaire.

Fonctionnalités optionnelles BONUS

Gestion de conflit

    Pour chaque joueur un timer régis par un Thread est associé. Il démarre lorsque son joueur obtient la main pour répondre à la question, et s’arrête dès que la réponse est fournie.
    En cas d’égalité de scores entre les joueurs à une phase donnée, ils seront départagés grâce aux valeurs des timers. Ainsi, les joueurs ayant été les plus rapides seront ceux qui se qualifient à la phase d’après.
    Dans le cas d’égalité, à la fois, des scores et timers, proposer jusqu’à trois questions supplémentaires pour les départager. Après cela, faire une sélection aléatoire pour passer à l’étape suivante. 

Le grand jeu

    Faire en sorte que l’application permette de considérer 3 groupes de 4 joueurs : 
        - Implémenter une partie de jeu pour chaque groupe de 4 joueurs
        - Récupérer les numéros des trois joueurs gagnants
        - Implémenter le grand jeu entre les trois joueurs gagnants, la même politique est reprise commençant à la phase II qui comportera trois thèmes au choix et une question par joueur.
        - Affichant toutes les étapes du déroulement du jeu. 

Implémenter une IA

    Utiliser les threads pour jouer le rôle de joueurs et répondre aléatoirement aux questions dans le cadre d’une partie de jeu complète.
