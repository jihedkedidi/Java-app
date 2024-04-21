package jeu3;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class JeuCalculMental {

    private final int NOMBRE_OPERATIONS = 10;
    private final int MIN = 1; // Valeur minimale des opérandes
    private final int MAX = 20; // Valeur maximale des opérandes
    private int nombreOperations;
    private Timer minuterie;
    boolean estTermine;
    private int score;
    private OperationMathematique operation;
    private final int DUREE_FACILE = 40; // Durée de jeu pour le niveau facile en secondes
    private final int DUREE_MOYENNE = 60; // Durée de jeu pour le niveau moyen en secondes
    private final int DUREE_DIFFICILE = 80;

    public JeuCalculMental() {

        estTermine = false;
        score = 0;
    }

    public void jouer(int niveauDifficulte) {
        minuterie = new Timer();
        Scanner scanner = new Scanner(System.in);
        long debut = System.currentTimeMillis(); // Début du jeu

        int duree = 0;
        switch (niveauDifficulte) {
            case 1:
                nombreOperations = 5;
                System.out.println("Vous avez choisi le niveau Facile.");
                duree = DUREE_FACILE;
                break;
            case 2:
                nombreOperations = 10;
                System.out.println("Vous avez choisi le niveau Moyen.");
                duree = DUREE_MOYENNE;
                break;
            case 3:
                nombreOperations = 15;
                System.out.println("Vous avez choisi le niveau Difficile.");
                duree = DUREE_DIFFICILE;
                break;
            default:
                nombreOperations = 10;
                System.out.println("Niveau de difficulté invalide. Utilisation de la durée par défaut.");
                duree = DUREE_MOYENNE;
                break;
        }

        System.out.println("Temps restant : " + duree + " secondes");


        minuterie.schedule(new FinJeuTask(), duree * 1000);
            // Continuer à demander des réponses jusqu'à ce que le temps soit écoulé
        while (!estTermine) {
            // Afficher le temps restant
            long tempsRestant = duree - (System.currentTimeMillis() - debut) / 1000;
            if (tempsRestant > 0) {
                System.out.println("Temps restant : " + tempsRestant + " secondes");
            } else {
                System.out.println("Temps écoulé !");
                break;
            }
            // Générer une nouvelle opération mathématique
            OperationMathematique operation = new OperationMathematique(MIN, MAX,niveauDifficulte);
            System.out.println("Opération : " + operation.getOperation());

            // Demander à l'utilisateur de saisir la réponse
            System.out.print("Votre réponse : ");
            float reponse;
            try {
                reponse = Float.parseFloat(scanner.next()); // Lire une chaîne de caractères et la convertir en flottant
            } catch (NumberFormatException e) {
                System.out.println("Saisie invalide. Veuillez saisir un nombre valide.");
                return; // Retourner à la boucle de jeu
            }

            // Vérifier si la réponse est correcte

            if (reponse == operation.getResultat()) {
                System.out.println("Bonne réponse !");
                score++;
            } else {
                System.out.println("Mauvaise réponse. Le résultat était : " + operation.getResultat());
            }
        }

        System.out.println("Votre score final est : " + score + " sur " + NOMBRE_OPERATIONS);
            if (score >= 0 && score <= 4) {
                System.out.println("Désolé, vous avez échoué. Votre score est trop bas pour obtenir une mention.");
            } else if (score >= 5 && score <= 9) {
                System.out.println("Félicitations ! Vous avez réussi avec mention bien.");
            } else if (score == 10) {
                System.out.println("Félicitations ! Vous avez réussi avec mention excellente ! Vous avez gagné un cadeau !");
            } else {
                System.out.println("Score invalide.");
            }



    }


    class FinJeuTask extends TimerTask {
        @Override
        public void run() {
            if (!estTermine) {
                System.out.println("Temps écoulé ! Le jeu est terminé.");
                System.out.println("Votre score final est : " + score);
                estTermine = true;
                minuterie.cancel();
            }
        }

    }
}


