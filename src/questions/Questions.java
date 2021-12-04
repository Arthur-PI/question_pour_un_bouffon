package questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import questions.TypeQuestion;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

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

	public void loadQuestions() throws FileNotFoundException {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(QUESTIONS_FILE));
		JsonQuestion[] json_questions = gson.fromJson(reader, JsonQuestion[].class);
		int a = 0, b = 0, c = 0;
		for (JsonQuestion q : json_questions) {
			if (q.getType() == TypeQuestion.QCM) {
				a++;
				this.addQuestion(new QuestionQCM(q.getQuestion(), q.getNiveau(), q.getTheme(), Integer.parseInt(q.getReponse()), q.getChoix()));
			}
			if (q.getType() == TypeQuestion.VRAI_FAUX) b++;
			if (q.getType() == TypeQuestion.LIBRE) c++;
		}
		System.out.println(a + " questions QCM");
		System.out.println(b + " questions vrai/faux");
		System.out.println(c + " questions libre");
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
