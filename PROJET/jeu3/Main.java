package jeu3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JeuCalculMental jeu = new JeuCalculMental();
        System.out.println("Choisissez le niveau de difficulté :");
        System.out.println("1 - Facile");
        System.out.println("2 - Moyen");
        System.out.println("3 - Difficile");
        Scanner scanner = new Scanner(System.in);
        int choixNiveau = scanner.nextInt();
        jeu.jouer(choixNiveau);



    }
}