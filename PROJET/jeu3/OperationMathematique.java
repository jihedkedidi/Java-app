package jeu3;

import java.util.Random;

public class OperationMathematique {
    private int nombre1;
    private int nombre2;
    private int nombre3;
    private char operateur;

    public OperationMathematique(int min, int max, int niveau) {
        Random random = new Random();
        nombre1 = random.nextInt(max - min + 1) + min;
        nombre2 = random.nextInt(max - min + 1) + min;
        nombre3 = random.nextInt(max - min + 1) + min;

        switch (niveau) {
            case 1: // Niveau facile
                operateur = random.nextBoolean() ? '+' : '-';
                break;
            case 2: // Niveau moyen
                int choixOperateurMoyen = random.nextInt(2);
                operateur = choixOperateurMoyen == 0 ? '*' : '/';
                break;
            case 3: // Niveau difficile
                int choixOperateurDifficile = random.nextInt(4);
                switch (choixOperateurDifficile) {
                    case 0:
                        operateur = random.nextBoolean() ? '+' : '-';
                        break;

                    case 1:
                        operateur = '*';
                        break;

                    case 2:
                        operateur =  '/';
                        break;
                    case 3:
                        operateur = '^';
                        break;

                }
                break;
        }
    }

    public String getOperation() {
        return nombre1 + " " + operateur + " " + nombre2;
    }

    public double getResultat() {

        return switch (operateur) {
            case '+' -> nombre1 + nombre2;
            case '-' -> nombre1 - nombre2;
            case '*' -> nombre1 * nombre2;
            case '/' -> (double) nombre1 / nombre2;
            case '^' -> Math.pow(nombre1, nombre2);
            default -> 0;
        };
    }
}

