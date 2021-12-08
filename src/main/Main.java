package main;
import jeu.Phases;

public class Main {
	public static void main (String[] args) {
		try {
			Class.forName("questions.Questions");
			Phases p = new Phases();
			p.phase1();
			p.phase2();
			p.phase3();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}