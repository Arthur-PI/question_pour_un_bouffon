package questions;

public abstract class Question {
	private final String question;
	private final Difficulties difficulty;
	private final String theme;

	public Question(String question, Difficulties difficulty, String theme) {
		this.question = question;
		this.difficulty = difficulty;
		this.theme = theme;
	}

	public String getQuestion () {
		return question;
	}

	public Difficulties getDifficulty() {
		return difficulty;
	}

	public String getTheme() {
		return theme;
	}

	public abstract boolean checkResponse(String response);

	public String toString(){
		return question;
	}
}
