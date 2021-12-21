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
Role : Cette classe contient la classe JsonQuestion permettant de faire la 
transisition entre le fichier JSON et les différents classes Questions.
Il fait partie du package "Questions"

------------------------------------------------------------------------------ */


package questions;

public class JsonQuestion {
	private TypeQuestion type;
	private int niveau;
	private String theme;
	private String question;
	private String[] choix;
	private String reponse;

	// GETTER et SETTER de la classe

	public TypeQuestion getType () {
		return type;
	}

	public int getNiveau () {
		return niveau;
	}

	public String getTheme () {
		return theme;
	}

	public String getQuestion () {
		return question;
	}

	public String[] getChoix () {
		return choix;
	}

	public String getReponse () {
		return reponse;
	}
}