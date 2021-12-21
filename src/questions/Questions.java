/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Cette classe contient la classe Questions qui contient toutes les questions
du jeu et qui est un singleton qui se charge au début et qui lit toutes les
questions dans un fichier JSON
Elle fait partie du package "questions"

------------------------------------------------------------------------------ */
package questions;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Lis et stock toutes les questions dans un ArrayList
 */
public class Questions {
	private static final String QUESTIONS_FILE = "questions.json";
	private static final Questions instance;
	private final ArrayList<Question> questions;

	// bloc satic qui se lance au charghement du programme
	static {
		instance = new Questions();
	}

	// Contructeur privé
	private Questions() {
		questions = new ArrayList<>();
		try {
			this.loadQuestions();
		} catch (FileNotFoundException e) {
			System.out.println("Error while loading questions !");
		}
	}

	/**
	 * Permet d'ajouter une question à la liste
	 * @param q la question a ajouter
	 */
	public void addQuestion(Question q) {
		questions.add(q);
	}

	/**
	 * permet de récuper l'instance de la classe. Fais un peu office de constructeur
	 * @return l'instance unique de la classe Questions
	 */
	public static Questions getInstance() {
		return instance;
	}

	/**
	 * Permet le chargement de toutes les questions à partir du fichier JSON
	 * @throws FileNotFoundException
	 */
	private void loadQuestions() throws FileNotFoundException {
		Gson gson;
		JsonReader reader;
		JsonQuestion[] json_questions;

		gson = new Gson();
		reader = new JsonReader(new FileReader(QUESTIONS_FILE));
		json_questions = gson.fromJson(reader, JsonQuestion[].class);
		for (JsonQuestion q : json_questions) {
			switch (q.getType()) {
				case QCM -> this.addQuestion(new QuestionQCM(q.getQuestion(), Difficulties.getDifficulty(q.getNiveau()), q.getTheme(), Integer.parseInt(q.getReponse()), q.getChoix()));
				case VRAI_FAUX -> this.addQuestion(new QuestionVraiFaux(q.getQuestion(), Difficulties.getDifficulty(q.getNiveau()), q.getTheme(), q.getReponse()));
				case LIBRE -> this.addQuestion(new QuestionLibre(q.getQuestion(), Difficulties.getDifficulty(q.getNiveau()), q.getTheme(), q.getReponse()));
				default -> System.out.println("Unknown Type of question !");
			}
		}
	}

	/**
	 * Permet de récuperer une question avec un theme et une difficulté donnée
	 * @param theme le theme de la question voulue
	 * @param level la difficulté de la question voulue
	 * @return une question qui correspond au theme et à la difficulté
	 */
	public Question getQuestion(String theme, Difficulties level) {
		Random rand = new Random();
		Question q;
		do {
			q = questions.get(rand.nextInt(questions.size()));
		} while (q.getDifficulty() != level || !q.getTheme().equals(theme));
		return q;
	}
}
