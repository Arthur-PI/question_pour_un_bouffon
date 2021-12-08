package main;

import questions.*;

import java.util.Objects;


public class Phases {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String alphabet[];
    private Joueurs game;
    private Themes themes;

    public Phases() {
        this.alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.game = new Joueurs();
        for (int i = 0; i < this.game.getJoueurs().length; i++) {
            this.game.getJoueurs()[i] = new Joueur(100+10*i, alphabet[i], 0,Status.ATTENTE);
        }
        this.themes = new Themes();
    }

    public void phase1() {
        System.out.println("\n _____________________________ \n Début de la phase 1 ... \n _____________________________ \n");
        this.game.generateParticipants();
        System.out.println(this.game);
        // début de la phase en déroulant chaque thèmes
        for (int i = 1; i < 11; i++) {
            //sélection d'un thème au hasard
            Theme theme= themes.selectRandomThemes();
            System.out.println(ANSI_CYAN + "\nQuestions numéro : "+i+"\nLe thème selectionné est :"+theme.getNom());
            // pour chaque joueur participant on génère une questions au hasard dans le thème
            for (int j = 0; j < this.game.getJoueurs().length ; j++) {
                if(this.game.getJoueurs()[j].getEtat() == Status.SELECTIONNER){
                    System.out.println(ANSI_PURPLE +"\nQuestion pour le joueur numéro :" + this.game.getJoueurs()[j].getNumero() + "\n");
                    Question q = Questions.getInstance().getQuestion(theme.getNom(), Difficulties.EASY );
                    System.out.println(ANSI_RESET +q);
                    String r = randomAnswer(q.getClass().toString());
                    System.out.println("\nRéponse du joueur : " + r);
                    if(q.checkResponse(r)){
                        System.out.println(ANSI_GREEN + "BONNE REPONSE");
                    }else{
                        System.out.println(ANSI_RED + "MAUVAISE REPONSE");
                    }
                }
            }
        }
    }

    public String randomAnswer(String type){
        if(Objects.equals(type, "class questions.QuestionVraiFaux")) {
            return "faux";
        }
        else if(Objects.equals(type, "class questions.QuestionQCM")) {
            return "2";
        }
        else if(Objects.equals(type, "class questions.QuestionLibre")) {
            return "test";
        }
        else{
            return "false";
        }
    }
}
