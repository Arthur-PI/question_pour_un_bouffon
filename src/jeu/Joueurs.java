/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Ce fichier contient la classe Joueurs contenant le tableau des joueurs de la partie 
en cours. Elle fait partie du package "JEU"

------------------------------------------------------------------------------ */

package jeu;

import java.util.ArrayList;
import java.util.List;

import static jeu.Status.*;


/**
 * Contient tous les joueurs d'une partie et de selectionner des participants
 */
public class Joueurs {
	public static final int JOUEURS_MAX = 20;
	private List<Joueur> joueurs;

	// GETTER ET SETTER
	public List<Joueur> getJoueurs () {
		return joueurs;
	}

	public void setJoueurs (List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

    // CONSTRUCTEUR
	public Joueurs (){
		this.joueurs = new ArrayList<>();
	}

	/**
	 * Renvoie un nombre entier au hasard entre la borne min et max inclus
	 * @param min borne inférieur
	 * @param max borne supérieur
	 * @return un int au hasard entre min et max inclus
	 */
	public static int getRandomDoubleBetweenRange(int min, int max) {
		double x = (Math.random() * (max - min)) + min;
		return (int) Math.round(x);
	}

	/**
	 * Permet d'ajouter un joueur à la liste
	 * @param j le joueur à ajouter
	 */
	public void addJoueur(Joueur j) {
		joueurs.add(j);
	}

	/**
	 * Selectionne un joueur au hasard dans la liste de joueurs
	 * @return un joueur au hasard
	 */
	public Joueur selectJoueur() {
		return joueurs.get(getRandomDoubleBetweenRange(0, joueurs.size() - 1));
	}

	/**
	 * génère les participants de la partie en modifiant
	 * leur état actuel en ATTENTE lorsqu'ils sont selectionnés
	 */
	public void generateParticipants(){
		for (int i = 0; i < 4; i++) {
			Joueur j1 = selectJoueur();
			do {
				if (j1 != null && j1.getEtat() == ATTENTE){
					j1.setEtat(SELECTIONNER);
				} else {
					j1 = selectJoueur();
				}
			} while (j1.getEtat() != SELECTIONNER);
		}
	}

	/**
	 * remet le score de tous les joueurs à 0
	 */
	public void resetScores() {
		for (Joueur j : joueurs)
			j.setScore(0);
	}

	/**
	 * Cherche puis renvoie le participant avec le score le moins élevé
	 * @return l'index du participant
	 */
	public int eliminateParticipant(){
		int index = -1;
		for (int i=0; i < joueurs.size(); i++) {
			if (joueurs.get(i).getEtat() == SELECTIONNER && (index == -1 || joueurs.get(i).getScore() < joueurs.get(index).getScore()))
				index = i;
		}
		return index;
	}

	/**
	 * Cherche puis renvoie le participant avec le score le plus élevé
	 * @return l'index du participant
	 */
	// winner regarde le joueur avec le score le plus haut de la partie et renvoie son index
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
