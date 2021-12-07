package main;

import questions.Difficulties;
import questions.Questions;

public class main {
	public static void main (String[] args) {
		try {
			Class.forName("questions.Questions");
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading class Question !");
		}
		Questions qs = Questions.getInstance();
		System.out.println(qs.getQuestion("Géographie", Difficulties.MEDIUM).getTheme());
	}
}