package metier;

public class Cours {

	private String theme;
	private int nbHeure;
	
	public Cours(String theme, int nbHeure) {
		super();
		this.theme = theme;
		this.nbHeure = nbHeure;
	}

	// GETTERS SETTERS //
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getNbHeure() {
		return nbHeure;
	}

	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}
}
