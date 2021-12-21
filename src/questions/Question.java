/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Cette classe permet d'abstraire les différents types de questions
Elle fait partie du package "Questions"

------------------------------------------------------------------------------ */

package questions;

/**
 * Classe abstraite pour les 3 types de questions
 */
public abstract class Question {
	private final String question;
	private final Difficulties difficulty;
	private final String theme;

	// CONSTRUCTEUR
	public Question(String question, Difficulties difficulty, String theme) {
		this.question = question;
		this.difficulty = difficulty;
		this.theme = theme;
	}

	// GETTER et SETTER de la classe
	public String getQuestion () {
		return question;
	}

	public Difficulties getDifficulty() {
		return difficulty;
	}

	public String getTheme() {
		return theme;
	}

	/**
	 * Permet de vérifier si une réponse a une question est bonne ou non
	 * @param response la reponse à vérifier
	 * @return true ou false si la reponse est vrai ou fausse
	 */
	public abstract boolean checkResponse(String response);

	public String toString(){
		return question;
	}
}
