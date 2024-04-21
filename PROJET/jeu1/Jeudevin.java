package jeu1;

import java.util.Random;

public class Jeudevin {
    private int nombreSecret;
    private final int nombreEssais=10;
    private Joueur[] joueurs = new Joueur[2];

    public Jeudevin() {
        joueurs[0] = new JoueurHumain();
        joueurs[1] = new Joueurpc();
       
    }

    public void initialiserJeu() {
        Random random = new Random();
        this.nombreSecret = random.nextInt(101);
      
        System.out.println("Nombre secret déjà généré. Entrez votre essai !");
    }

    public boolean verifierGagnant(int supposition) {
        return supposition == nombreSecret;
    }

    public void afficherGagnant() {
        System.out.println("Félicitations, vous avez gagné !");
    }

    public void donnerIndication(int supposition) {
        if (supposition > nombreSecret) {
            System.out.println("Trop haut !");
        } else if (supposition < nombreSecret) {
            System.out.println("Trop bas !");
        } else {
            System.out.println("Correct !");
        }
    }

    public void jouer() {
        initialiserJeu();
        for (int essai = 1; essai <= nombreEssais; essai++) {
            System.out.println("\nEssai #" + essai);
            Joueur joueur = joueurs[0];
            int supposition = joueur.deviner();
            donnerIndication(supposition);
            if (verifierGagnant(supposition)) {
                afficherGagnant();
                return; 
            }
        }
        System.out.println("\nDésolé, vous avez utilisé tous vos essais. Le nombre secret était : " + nombreSecret);
    }
}
