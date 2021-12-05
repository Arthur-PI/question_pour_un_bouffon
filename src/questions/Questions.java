package questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Questions {
	private static final String QUESTIONS_FILE = "questions.json";
	private static final Questions instance;
	private final ArrayList<Question> questions;

	static {
		instance = new Questions();
		try {
			instance.loadQuestions();
		} catch (FileNotFoundException e) {
			System.out.println("Error while loading questions !");
		}
	}

	private Questions() {
		questions = new ArrayList<>();
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public void deleteQuestion(int i) {
		if (i > 0 && i < questions.size()) questions.remove(i);
	}

	

	private void loadQuestions() throws FileNotFoundException {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(QUESTIONS_FILE));
		JsonQuestion[] json_questions = gson.fromJson(reader, JsonQuestion[].class);
		int a = 0, b = 0, c = 0;
		Question qstion;
		for (JsonQuestion q : json_questions) {
			switch (q.getType()) {
				case QCM -> this.addQuestion(new QuestionQCM(q.getQuestion(), Difficulties.getDifficulty(q.getNiveau()), q.getTheme(), Integer.parseInt(q.getReponse()), q.getChoix()));
				case VRAI_FAUX -> this.addQuestion(new QuestionVraiFaux(q.getQuestion(), Difficulties.getDifficulty(q.getNiveau()), q.getTheme(), q.getReponse()));
				case LIBRE -> this.addQuestion(new QuestionLibre(q.getQuestion(), Difficulties.getDifficulty(q.getNiveau()), q.getTheme(), q.getReponse()));
				default -> System.out.println("Unknown Type of question !");
			}
		}
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
