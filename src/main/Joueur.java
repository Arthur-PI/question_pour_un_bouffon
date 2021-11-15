package main;

public class Joueur {
	private int numero;
	private String nom;
	private int score;
	private Status etat;

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

	Joueur (int numero, String nom, int score, Status etat){
		this.numero = numero;
		this.nom = nom;
		this.score = score;
		this.etat = etat;
	}

	public void Saisie(int numero, String nom, int score, Status etat){
		setNumero(numero);
		setNom(nom);
		setScore(score);
		setEtat(etat);
	}

	public void incrementScore(int scoreToAdd){
		setScore(this.score + scoreToAdd);
	}

	@Override
	public String toString(){
		return "| "+getNumero()+ " | "+getNom()+ " | "+getEtat()+ " | "+getScore();
	}
}
