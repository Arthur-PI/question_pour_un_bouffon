package questions;

public class QuestionVraiFaux extends Question {
	private static final String TRUE = "true";
	private static final String VRAI = "vrai";
	private static final String FAUX = "faux";
	private final boolean response;

	public QuestionVraiFaux(String question, Difficulties difficulty, String theme, String response){
		super(question, difficulty, theme);
		this.response = response.equals(TRUE);
	}

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
