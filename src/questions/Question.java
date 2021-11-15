package questions;

import static questions.TypeQuestion.*;

public class Question {
	private String question;
	private String response;
	private String[] choices;
	private TypeQuestion type;
	private int difficulty;

	public Question (String question, String response, TypeQuestion type, int difficulty) {
		this.question = question;
		this.response = response;
		this.type = type;
		this.difficulty = difficulty;
	}

	public Question (String question, String response, String[] choices, TypeQuestion type, int difficulty) {
		this(question, response, type, difficulty);
		if (type == QCM) this.choices = choices;
	}

	public String getQuestion () {
		return question;
	}

	public void setQuestion (String question) {
		this.question = question;
	}

	public String getResponse () {
		return response;
	}

	public void setResponse (String response) {
		this.response = response;
	}

	public String[] getChoices () {
		return choices;
	}

	public void setChoices (String[] choices) {
		this.choices = choices;
	}

	public TypeQuestion getType () {
		return type;
	}

	public void setType (TypeQuestion type) {
		this.type = type;
	}

	public int getDifficulty () {
		return difficulty;
	}

	public void setDifficulty (int difficulty) {
		this.difficulty = difficulty;
	}

	public boolean checkResponse (String response) {
		return response.equals(this.response);
	}
}
