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
Role : Ce fichier contient la classe Joueur définissant les attributs d'un joueur
avec son nom, son numéro, son score et son état. Elle fait partie du package "JEU"

------------------------------------------------------------------------------ */

package jeu;

public class Joueur {
	private int numero;
	private String nom;
	private int score;
	private Status etat;

	// GETTER ET SETTER 

	public int getNumero () {
		return numero;
	}

	public void setNumero (int numero) {
		this.numero = numero;
	}

	public String getNom () {
		return nom;
	}

	public void setNom (String nom) {
		this.nom = nom;
	}

	public int getScore () {
		return score;
	}

	public void setScore (int score) {
		this.score = score;
	}

	public Status getEtat () {
		return etat;
	}

	public void setEtat (Status etat) {
		this.etat = etat;
	}

	// CONSTRUCTEUR

	public Joueur (int numero, String nom, int score, Status etat){
		this.numero = numero;
		this.nom = nom;
		this.score = score;
		this.etat = etat;
	}

	public Joueur(int numero, String nom) {
		this(numero, nom, 0, Status.ATTENTE);
	}

	// Saisie est une méthode permettant de saisir des nouvelles informations concernant le joueur

	public void Saisie(int numero, String nom, int score, Status etat){
		setNumero(numero);
		setNom(nom);
		setScore(score);
		setEtat(etat);
	}

	// incrementScore est une méthode permettant d'incrémenter le score d'une valeur passée en paramètre

	public void incrementScore(int scoreToAdd){
		setScore(this.score + scoreToAdd);
	}

	@Override
	public String toString(){
		return "| "+getNumero()+ " | "+getNom()+ " | "+getEtat()+ " | "+getScore()+"\n";
	}
}
