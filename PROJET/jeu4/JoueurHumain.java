package jeu4;

import java.util.Scanner;

class JoueurHumain implements Joueur {
    private Scanner scanner;

    public JoueurHumain() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Difficulte choisirDifficulte() {
        System.out.println("Choisissez le niveau de difficulté (FACILE, MOYEN ou DIFFICILE) : ");
        String choix = scanner.nextLine().toUpperCase();
        return Difficulte.valueOf(choix);
    }

    @Override
    public String devinerMot() {
        System.out.println("Entrez votre devinette : ");
        return scanner.nextLine();
    }

    @Override
    public String Continuer() {
        System.out.println("Voulez-vous continuer à jouer ? (oui/non) : ");
        return scanner.nextLine();
    }
}
