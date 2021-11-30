package questions;

import java.util.ArrayList;

public class Questions {
	private ArrayList<Question> questions;

	public Questions () {
		questions = new ArrayList<>();
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public void deleteQuestion(int i) {
		if (i > 0 && i < questions.size()) questions.remove(i);
	}

	public Question getQuestion(String theme){
		return questions.get(0);
	}
}
