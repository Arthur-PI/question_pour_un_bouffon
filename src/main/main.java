package main;
import static questions.TypeQuestion.*;

public class main {
	public static void main (String[] args) {
		Joueurs Game = new Joueurs();
		for (int i = 0; i < Game.getJoueurs().length; i++) {
			Game.getJoueurs()[i] = new Joueur(100+10*i, Integer.toString(i), 0,Status.ATTENTE);
		}
		Game.generateParticipants();
		System.out.println(Game);
	}
}
