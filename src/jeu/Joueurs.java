package jeu;

import java.util.ArrayList;
import java.util.List;

import static jeu.Status.*;

public class Joueurs {
	public static final int JOUEURS_MAX = 20;
	private List<Joueur> joueurs;


	public List<Joueur> getJoueurs () {
		return joueurs;
	}

	public void setJoueurs (List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Joueurs (){
		this.joueurs = new ArrayList<>();
	}

	public static int getRandomDoubleBetweenRange(int min, int max){
		double x = (Math.random() * (max - min)) + min;
		return (int) Math.round(x);
	}

	public void addJoueur(Joueur j) {
		joueurs.add(j);
	}

	public Joueur selectJoueur() {
		return joueurs.get(getRandomDoubleBetweenRange(0, joueurs.size() - 1));
	}

	public void generateParticipants(){
		for (int i = 0; i < 4; i++) {
			Joueur j1 = selectJoueur();
			do {
				if (j1 != null && j1.getEtat() == ATTENTE){
					j1.setEtat(SELECTIONNER);
				} else {
					j1 = selectJoueur();
				}
			}while (j1.getEtat() != SELECTIONNER);
		}
	}

	public void resetScores() {
		for (Joueur j : joueurs)
			j.setScore(0);
	}

	public int eliminateParticipant(){
		int index = -1;
		for (int i=0; i < joueurs.size(); i++) {
			if (joueurs.get(i).getEtat() == SELECTIONNER && (index == -1 || joueurs.get(i).getScore() < joueurs.get(index).getScore()))
				index = i;
		}
		return index;
	}

	public int winner(){
		int index = -1;
		for (int i=0; i < joueurs.size(); i++) {
			if (joueurs.get(i).getEtat() == SELECTIONNER && (index == -1 || joueurs.get(i).getScore() > joueurs.get(index).getScore()))
				index = i;
		}
		return index;
	}


	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		for (Joueur joueur : joueurs) {
			if (joueur.getEtat() != ATTENTE) {
				chaine.append(joueur);
			}
		}
		return chaine.toString();
	}
}
