/* ------------------------------------------------------------------------------

      ##    ###    ##     ##    ###    
      ##   ## ##   ##     ##   ## ##   
      ##  ##   ##  ##     ##  ##   ##  
      ## ##     ## ##     ## ##     ## 
##    ## #########  ##   ##  ######### 
##    ## ##     ##   ## ##   ##     ## 
 ######  ##     ##    ###    ##     ## 

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Ce fichier contient la classe Phases contenant toutes les phases du jeu.
Elle fait partie du package "JEU"

------------------------------------------------------------------------------ */

package jeu;

import questions.*;

import java.util.List;
import java.util.Scanner;


public class Phases {
    // variable pour ajouter de la couleur dans la console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private final Joueurs game;
    private final Themes themes;

    // création de la partie dans le constructeur

    public Phases() {
        // création du tableau de joueurs
        this.game = new Joueurs();
        // génération des thèmes
        this.themes = new Themes();
        // saisie de tous les pseudos 1 par 1 
        String pseudo;
        System.out.println("Saisie des participants (de 4 a 20 joueurs):");
        for (int i=0; i < Joueurs.JOUEURS_MAX; i++) {
            System.out.println("Nom du joueur " + (i + 1) + " ('stop' pour arreter):");
            pseudo = getUserInput();
            if (pseudo.trim().equalsIgnoreCase("stop"))
                if (i > 3)
                    break;
                else {
                    i--;
                    continue;
                }
            this.game.addJoueur(new Joueur(i + 1, pseudo));
        }
    }

    public void phase1() {
        game.generateParticipants();
        System.out.println("\n _____________________________ \n Début de la phase 1 ... \n _____________________________ \n");
        System.out.println(game);
        List<Joueur> joueurs = game.getJoueurs();
        // début de la phase en déroulant chaque thèmes
        for (int i = 1; i < 11; i++) {
            //sélection d'un thème au hasard
            Theme theme= themes.selectRandomThemes();
            System.out.println(ANSI_CYAN + "\nQuestions numéro : " + i + "\nLe thème selectionné est: " + theme.getNom());
            // pour chaque joueur participant on génère une questions au hasard dans le thème
            for (Joueur joueur : joueurs) {
                if (joueur.getEtat() == Status.SELECTIONNER) {
                    System.out.println(ANSI_PURPLE + "\nQuestion pour le joueur numéro: " + joueur.getNumero() + "\n");
                    Question q = Questions.getInstance().getQuestion(theme.getNom(), Difficulties.EASY);
                    System.out.println(ANSI_WHITE + q.getTheme() + ANSI_RESET + " -> " + q);
                    String r = getUserInput();
                    System.out.println("\nRéponse du joueur: " + r);
                    if (q.checkResponse(r)) {
                        joueur.incrementScore(2);
                        System.out.println(ANSI_GREEN + "BONNE REPONSE");
                    } else {
                        System.out.println(ANSI_RED + "MAUVAISE REPONSE");
                    }
                }
            }
        }
        joueurs.get(game.eliminateParticipant()).setEtat(Status.ELIMINER);
        System.out.println("\n" + ANSI_RESET + game);
    }

    public void phase2() {
        System.out.println("\n _____________________________ \n\n Début de la phase 2 ... \n _____________________________ \n");
        game.resetScores();
        System.out.println(this.game);
        List<Joueur> joueurs = game.getJoueurs();
        for (int j = 0; j < 3; j++) {
            Theme theme= themes.selectRandomThemes();
            System.out.println(ANSI_CYAN + "\nLe thème selectionné est: " + theme.getNom());
            for (Joueur joueur : joueurs) {
                if (joueur.getEtat() == Status.SELECTIONNER) {
                    System.out.println(ANSI_PURPLE + "\nQuestion pour le joueur numéro: " + joueur.getNumero() + "\n");
                    Question q = Questions.getInstance().getQuestion(theme.getNom(), Difficulties.MEDIUM);
                    System.out.println(ANSI_WHITE + q.getTheme() + ANSI_RESET + " -> " + q);
                    String r = getUserInput();
                    System.out.println("\nRéponse du joueur: " + r);
                    if (q.checkResponse(r)) {
                        joueur.incrementScore(3);
                        System.out.println(ANSI_GREEN + "BONNE REPONSE");
                    } else {
                        System.out.println(ANSI_RED + "MAUVAISE REPONSE");
                    }
                }
            }
        }
        joueurs.get(game.eliminateParticipant()).setEtat(Status.ELIMINER);
        System.out.println("\n" + ANSI_RESET + game);
    }

    public void phase3() {
        System.out.println("\n _____________________________ \n Début de la phase 3 ... \n _____________________________ \n");
        game.resetScores();
        System.out.println(this.game);
        List<Joueur> joueurs = game.getJoueurs();
        for (int i = 0; i < 3; i++) {
            Theme theme= themes.selectRandomThemes();
            System.out.println(ANSI_CYAN + "\nLe thème selectionné est: " + theme.getNom());
            for (Joueur joueur : joueurs) {
                if (joueur.getEtat() == Status.SELECTIONNER) {
                    System.out.println(ANSI_PURPLE + "\nQuestion pour le joueur numéro: " + joueur.getNumero() + "\n");
                    Question q = Questions.getInstance().getQuestion(theme.getNom(), Difficulties.HARD);
                    System.out.println(ANSI_WHITE + q.getTheme() + ANSI_RESET + " -> " + q);
                    String r = getUserInput();
                    System.out.println("\nRéponse du joueur: " + r);
                    if (q.checkResponse(r)) {
                        joueur.incrementScore(5);
                        System.out.println(ANSI_GREEN + "BONNE REPONSE");
                    } else {
                        System.out.println(ANSI_RED + "MAUVAISE REPONSE");
                    }
                }
            }
        }
        joueurs.get(this.game.eliminateParticipant()).setEtat(Status.ELIMINER);
        joueurs.get(this.game.winner()).setEtat(Status.GAGNANT);
        System.out.println("\n" + ANSI_RESET + this.game);
    }

    public String getUserInput(){
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        return in.nextLine();
    }
}
