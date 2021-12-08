package main;

import static main.Status.*;

public class Joueurs {
	private Joueur[] joueurs;

	public Joueur[] getJoueurs () {
		return joueurs;
	}

	public void setJoueurs (Joueur[] joueurs) {
		this.joueurs = joueurs;
	}

	Joueurs (){
		this.joueurs = new Joueur[20];
	}

	public static int getRandomDoubleBetweenRange(int min, int max){
		double x = (Math.random() * (max - min)) + min;
		return (int) Math.round(x);
	}

	public Joueur selectJoueur() {
		return this.joueurs[getRandomDoubleBetweenRange(0, 19)];
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

	public int eliminateParticipant(){
		int index = 0;
		for (int i = 0; i < this.joueurs.length; i++) {
			if(this.joueurs[i].getEtat() == SELECTIONNER){
				for (int j = 0; j < this.joueurs.length; j++) {
					if(this.joueurs[j].getEtat() == SELECTIONNER){
						if(this.joueurs[i].getScore() > this.joueurs[j].getScore()) index = j;
					}
				}
			}
		}
		return index;
	}

	public int winner(){
		int index = 0;
		for (int i = 0; i < this.joueurs.length; i++) {
			if(this.joueurs[i].getEtat() == SELECTIONNER) {
				if (this.joueurs[i].getScore() > this.joueurs[i+1].getScore()) index = i;
			}
		}
		return index;
	}


	@Override
	public String toString(){
		StringBuilder chaine = new StringBuilder();
		for (int i = 0; i < this.joueurs.length; i++) {
			if(this.joueurs[i].getEtat() != ATTENTE){
				chaine.append(this.joueurs[i].toString());
			}
		}
		return chaine.toString();
	}
}
