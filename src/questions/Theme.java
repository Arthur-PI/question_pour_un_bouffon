/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Cette classe contient la classe Theme correspond à un theme donné
Elle fait partie du package "questions"

------------------------------------------------------------------------------ */
package questions;

/**
 * Contient toutes les information sur un thème
 */
public class Theme {
    private String nom;

    // GETTER et SETTER
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

    public Theme(String nom, boolean indicateur){
        this.nom = nom;
        this.indicateur = indicateur;
    }

    @Override
    public String toString(){
        return this.nom + " | " +this.indicateur+"\n";
    }
}
