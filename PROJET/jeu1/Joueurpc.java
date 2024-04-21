package jeu1;

import java.util.Random;

public class Joueurpc implements Joueur {

    Random random = new Random();


    @Override
    public int deviner() {
        return random.nextInt(10)+1;
    }
    
}
