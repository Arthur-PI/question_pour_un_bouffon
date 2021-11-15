package main;
import questions.Question;
import questions.TypeQuestion;

import static questions.TypeQuestion.*;

public class main {
	public static void main (String[] args) {
		String alphabet[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Joueurs Game = new Joueurs();
		for (int i = 0; i < Game.getJoueurs().length; i++) {
			Game.getJoueurs()[i] = new Joueur(100+10*i, alphabet[i], 0,Status.ATTENTE);
		}
		Game.generateParticipants();
		System.out.println(Game);

		Question q = new Question("Quel est le nom du personnage principal dans Tokyo Ghoul ?", "Kaneki Ken", new String[]{"Kaneki Ken", "Senjuro Funebaichi", "Lize Sukehiro"}, QCM, 1);
		System.out.println(q);
	}
}
