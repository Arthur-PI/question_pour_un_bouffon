package main;
import questions.Question;
import questions.Questions;
import questions.Themes;


import static questions.TypeQuestion.*;

public class main {
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