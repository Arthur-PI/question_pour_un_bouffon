/* ------------------------------------------------------------------------------

Projet : Question pour un bouffon
Auteurs : PIGEON Arthur, BILLAUD Victor, BENOUDA Karim, JOVANOVIC Ivan
Role : Cette classe contient la classe Themes contient tous les themes qui existent
Elle fait partie du package "questions"

------------------------------------------------------------------------------ */
package questions;

import java.util.ArrayList;

public class Themes {
    private final ArrayList<Theme> themes;
    private int nbThemes;

    public Themes() {
        this.themes = new ArrayList<Theme>();
        this.nbThemes = 0;
        this.themes.add(new Theme("Sport",false));
        this.themes.add(new Theme("Géographie",false));
        this.themes.add(new Theme("Histoire",false));
        this.themes.add(new Theme("Cinématographie",false));
        this.themes.add(new Theme("Science et Nature",false));
        this.themes.add(new Theme("Musique",false));
        this.themes.add(new Theme("Animé",false));
        this.themes.add(new Theme("Informatique",false));
        this.themes.add(new Theme("Divertissement",false));
        this.themes.add(new Theme("Mathématiques",false));
    }

    public int indexOf(String theme){
        for (int i = 0; i < this.themes.size(); i++) {
            if(this.themes.get(i).getNom().equals(theme)){
                return i;
            };
        }
        return 0;
    }

    public static int getRandomDoubleBetweenRange(int min, int max){
        double x = (Math.random() * (max - min)) + min;
        return (int) Math.round(x);
    }

    public int selectTheme(String theme){
        return indexOf(theme);
    }

    public Theme selectRandomThemes() {
        Theme selectedTheme;
        do {
            selectedTheme =  this.themes.get(getRandomDoubleBetweenRange(0,9));
            if (nbThemes == 10) {
                nbThemes = 0;
                for (Theme theme : this.themes) {
                    theme.setIndicateur(false);
                }
            }
        } while (selectedTheme.isIndicateur());
        selectedTheme.setIndicateur(true);
        nbThemes++;
        return selectedTheme;
    }

    @Override
    public String toString(){
        StringBuilder chaine = new StringBuilder();
        for (Theme theme : this.themes) {
            chaine.append(theme.toString());
        }
        return chaine.toString();
    }

}
