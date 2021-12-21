/* ------------------------------------------------------------------------------

      ##    ###    ##     ##    ###    
      ##   ## ##   ##     ##   ## ##   
      ##  ##   ##  ##     ##  ##   ##  
      ## ##     ## ##     ## ##     ## 
##    ## #########  ##   ##  ######### 
##    ## ##     ##   ## ##   ##     ## 
 ######  ##     ##    ###    ##     ## 

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Ce fichier contient les différentes difficultés des questions
Il fait partie du package "Questions"

------------------------------------------------------------------------------ */

package questions;

public enum Difficulties {
	EASY,
	MEDIUM,
	HARD;

	public static Difficulties getDifficulty(int i) {
		return switch (i) {
			case 2 -> (MEDIUM);
			case 3 -> (HARD);
			default -> (EASY);
		};
	}
}
