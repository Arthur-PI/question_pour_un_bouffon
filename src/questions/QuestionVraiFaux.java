/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Cette classe contient la classe QuestionsVraiFaux qui est une implémentation
la classe Question
Elle fait partie du package "questions"

------------------------------------------------------------------------------ */
package questions;

/**
 * Type de question avec choix binaire, qui accepte soit 'vrai' soit 'faux'
 */
public class QuestionVraiFaux extends Question {
	private static final String TRUE = "true";
	private static final String VRAI = "vrai";
	private static final String FAUX = "faux";
	private final boolean response;

	public QuestionVraiFaux(String question, Difficulties difficulty, String theme, String response){
		super(question, difficulty, theme);
		this.response = response.equals(TRUE);
	}

	/**
	 * Permet de vérifier si une réponse a une question est bonne ou non
	 * @param response la reponse à vérifier
	 * @return true ou false si la reponse est vrai ou fausse
	 */
	@Override
	public boolean checkResponse(String response) {
		response = response.trim().toLowerCase();
		if ((response.equals(VRAI) && this.response) || (response.equals(FAUX) && !this.response))
			return true;
		return false;
	}

	@Override
	public String toString () {
		return super.toString() + " (Vrai/Faux)";
	}
}
