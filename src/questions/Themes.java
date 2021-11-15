package questions;

import java.util.ArrayList;

public class Themes {
    private ArrayList<Theme> themes;

    Themes() {
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

    public int SelectTheme(String theme){
        return indexOf(theme);
    }



}
