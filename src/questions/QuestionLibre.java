package questions;

public class QuestionLibre extends Question {
	private final String response;

	public QuestionLibre(String question, Difficulties difficulty, String theme, String response) {
		super(question, difficulty, theme);
		this.response = response.trim().toLowerCase();
	}

	@Override
	public boolean checkResponse(String response) {
		response = response.trim().toLowerCase();
		return response.equals(this.response);
	}
}
