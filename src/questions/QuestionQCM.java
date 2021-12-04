package questions;

import java.util.Arrays;

public class QuestionQCM extends Question {
	private final int response;
	private final String[] choices;

	public QuestionQCM(String question, Difficulties difficulty, String theme, int response, String[] choices) {
		super(question, difficulty, theme);
		this.response = response;
		this.choices = choices;
	}

	@Override
	public boolean checkResponse(String response) {
		return Integer.parseInt(response) == this.response;
	}

	@Override
	public String toString () {
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		for (int i=0; i < choices.length; i++) {
			s.append('\n');
			s.append(i);
			s.append("- ");
			s.append(choices[i]);
		}
		return s.toString();
	}
}
