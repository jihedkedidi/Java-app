package jeu1;

import java.util.Scanner;

public class JoueurHumain implements Joueur {
    private Scanner scanner = new Scanner (System.in);


    public int deviner() {
      return scanner.nextInt();
    }
}
