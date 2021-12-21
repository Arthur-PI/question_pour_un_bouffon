/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Ce fichier contient les différentes difficultés des questions
Il fait partie du package "Questions"

------------------------------------------------------------------------------ */

package questions;

/**
 * Contient les trois difficultés présentent dans le jeu
 */
public enum Difficulties {
	EASY,
	MEDIUM,
	HARD;

	/**
	 * Fais correspondre un int a un enum de difficulté
	 * @param i un int qui correspond à une difficulté
	 * @return l'enum correspondant à la bonne difficulté
	 */
	public static Difficulties getDifficulty(int i) {
		return switch (i) {
			case 2 -> (MEDIUM);
			case 3 -> (HARD);
			default -> (EASY);
		};
	}
}
