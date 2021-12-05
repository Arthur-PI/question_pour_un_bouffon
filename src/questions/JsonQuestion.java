package questions;

public class JsonQuestion {
	private TypeQuestion type;
	private int niveau;
	private String theme;
	private String question;
	private String[] choix;
	private String reponse;

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