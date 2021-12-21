/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Cette classe contient la classe QuestionsQCM qui est une implémentation
la classe Question
Elle fait partie du package "questions"

------------------------------------------------------------------------------ */
package questions;

/**
 * Type de question avec 3 choix, qui accepte comme reponse soit 1, 2 ou 3
 */
public class QuestionQCM extends Question {
	private final int response;
	private final String[] choices;

	public QuestionQCM(String question, Difficulties difficulty, String theme, int response, String[] choices) {
		super(question, difficulty, theme);
		this.response = response;
		this.choices = choices;
	}

	/**
	 * Permet de vérifier si une réponse a une question est bonne ou non
	 * @param response la reponse à vérifier
	 * @return true ou false si la reponse est vrai ou fausse
	 */
	@Override
	public boolean checkResponse(String response) {
		try {
			return Integer.parseInt(response) == this.response;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public String toString () {
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		for (int i=0; i < choices.length; i++) {
			s.append('\n');
			s.append(i + 1);
			s.append("- ");
			s.append(choices[i]);
		}
		return s.toString();
	}
}
