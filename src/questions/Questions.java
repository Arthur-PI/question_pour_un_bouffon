package questions;

import java.util.ArrayList;
import java.util.Random;

public class Questions {
	private static final String QUESTIONS_FILE = "questions.json";
	private final ArrayList<Question> questions;

	public Questions() {
		questions = new ArrayList<>();
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public void deleteQuestion(int i) {
		if (i > 0 && i < questions.size()) questions.remove(i);
	}

	public void loadQuestions() {

	}

	public Question getQuestion(String theme, Difficulties level) {
		Random rand = new Random();
		Question q;
		int n;
		do {
			q = questions.get(rand.nextInt(questions.size()));
		} while (q.getDifficulty() == level && !q.getTheme().equals(theme));
		return q;
	}
}
