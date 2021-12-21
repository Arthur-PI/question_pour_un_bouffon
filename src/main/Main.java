package main;
import jeu.Phases;

public class Main {
	public static void main (String[] args) {
		try {
			Class.forName("questions.Questions");
			// Création de l'objet phase contenant toutes les phases
			Phases p = new Phases();
			//déroulement de la phase 1
			p.phase1();
		} catch (ClassNotFoundException e) {
			//en cas d'erreur lors de la création des questions on stop l'execution
			e.printStackTrace();
		}
	}
}
