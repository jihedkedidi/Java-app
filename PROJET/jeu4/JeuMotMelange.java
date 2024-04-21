package jeu4;

import java.util.Random;

// Classe pour le jeu
public class JeuMotMelange {
    private String[] mots = {"programmation", "ordinateur", "developpeur", "algorithmique", "java","REDHAT","CLUBAFRICAIN"
            ,"DORTUMEND","REAL MADRID"};
    private Joueur joueur;
    private Difficulte difficulte;


    public JeuMotMelange(Joueur joueur) {
        this.joueur = joueur;
    }

    // Méthode pour mélanger un mot
    private String melangerMot(String mot) {
        Random random = new Random();
        char[] caracteres = mot.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            int j = random.nextInt(caracteres.length);
            char temp = caracteres[i];
            caracteres[i] = caracteres[j];
            caracteres[j] = temp;
        }
        return new String(caracteres);
    }

    // Méthode pour donner une suggestion en fonction de la difficulté
    private void donnerSuggestion(String mot) {
        switch (difficulte) {
            case FACILE:
                System.out.println("Ceci est un mot " + mot.length() + " lettres.");
                break;
            case MOYEN:
                System.out.println("La première lettre du mot est : " + mot.charAt(0));
                break;
            case DIFFICILE:
                System.out.println("Le mot commence par : " + mot.substring(0, 2));
                break;
        }
    }

    // Méthode pour jouer au jeu
    public void jouer() {
        boolean continuer = true;
        while (continuer) {
            difficulte = joueur.choisirDifficulte();
            String Mot = mots[new Random().nextInt(mots.length)];
            String Melange = melangerMot(Mot);
            System.out.println("Mot mélangé : " + Melange);
            donnerSuggestion(Mot);
            String devinette = joueur.devinerMot();
            if (devinette.equals(Mot)) {
                System.out.println("Bravo ! GG");
            } else {
                System.out.println("Désolé le mot est " + Mot);
            }
            String choix = joueur.Continuer().toLowerCase();
            if (!choix.equals("oui")) {
                continuer = false;
                System.out.println("bye bye gg");
            }
        }
    }
    
    }

