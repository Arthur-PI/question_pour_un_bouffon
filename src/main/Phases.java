package main;

import questions.Themes;

public class Phases {
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
        this.game.generateParticipants();
        System.out.println(this.game);
        System.out.println(this.themes);
        for (int i = 0; i < 10; i++) {
            themes.selectRandomThemes();
        }
        System.out.println(this.themes);
    }
}
