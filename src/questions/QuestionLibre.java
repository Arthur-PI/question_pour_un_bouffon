/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Cette classe contient la classe QuestionsLibre qui est une implémentation
la classe Question
Elle fait partie du package "questions"

------------------------------------------------------------------------------ */
package questions;

/**
 * Type de question avec une reponse libre, que ça soit une phrase, un mot.
 */
public class QuestionLibre extends Question {
	private final String response;

	public QuestionLibre(String question, Difficulties difficulty, String theme, String response) {
		super(question, difficulty, theme);
		this.response = response.trim().toLowerCase();
	}

	/**
	 * Permet de vérifier si une réponse a une question est bonne ou non
	 * @param response la reponse à vérifier
	 * @return true ou false si la reponse est vrai ou fausse
	 */
	@Override
	public boolean checkResponse(String response) {
		response = response.trim().toLowerCase();
		return response.equals(this.response);
	}
}
