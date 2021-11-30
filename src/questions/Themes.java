package questions;

import java.util.ArrayList;

import static main.Status.SELECTIONNER;

public class Themes {
    private ArrayList<Theme> themes;
    private int nbThemes;

    public Themes() {
        this.themes = new ArrayList<Theme>();
        this.nbThemes = 0;
        this.themes.add(new Theme("Sport",false));
        this.themes.add(new Theme("Géographie",false));
        this.themes.add(new Theme("Histoire",false));
        this.themes.add(new Theme("Cinéma",false));
        this.themes.add(new Theme("Science et nature",false));
        this.themes.add(new Theme("Musique",false));
        this.themes.add(new Theme("Anime",false));
        this.themes.add(new Theme("Informatique",false));
        this.themes.add(new Theme("Divertissement",false));
        this.themes.add(new Theme("Maths",false));
    }

    public int indexOf(String theme){
        for (int i = 0; i < this.themes.size(); i++) {
            if(this.themes.get(i).getNom() == theme){
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
        Theme selectTheme =  this.themes.get(getRandomDoubleBetweenRange(0,9));
        do {
            selectTheme =  this.themes.get(getRandomDoubleBetweenRange(0,9));
            if (nbThemes == 10) {
                nbThemes = 0;
                for (int i = 0; i < this.themes.size(); i++) {
                    this.themes.get(i).setIndicateur(false);
                }
            }
        } while (selectTheme.isIndicateur());
        selectTheme.setIndicateur(true);
        nbThemes++;
        System.out.println(nbThemes);
        return selectTheme;
    }

    @Override
    public String toString(){
        StringBuilder chaine = new StringBuilder();
        for (int i = 0; i < this.themes.size(); i++) {
                chaine.append(this.themes.get(i).toString());
        }
        return chaine.toString();
    }

}
