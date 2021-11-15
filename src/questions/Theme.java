package questions;

public class Theme {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isIndicateur() {
        return indicateur;
    }

    public void setIndicateur(boolean indicateur) {
        this.indicateur = indicateur;
    }

    private boolean indicateur;

    Theme(String nom, boolean indicateur){
        this.nom = nom;
        this.indicateur = indicateur;
    }

    @Override
    public String toString(){
        return this.nom + " | " +this.indicateur+"\n";
    }
}
