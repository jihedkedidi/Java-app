import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("HELLO IN OUR GAMES! let's GO !");
            System.out.println("===== Menu Principal =====");
            System.out.println("1... Jeu 1 'Jeu Devin'");
            System.out.println("2... Jeu 2 'GameContry'");
            System.out.println("3... Jeu 3 ' CalculMental'");
            System.out.println("4... Jeu 4 'Mot_Mele'");
            System.out.println("5... Jeu 5 'Jeu de Quiz'");
            System.out.println("0. QUITTEZ!");
            System.out.println("entrez votre choix!");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    jeu1.MainJeu1.main(null);
                    break;
                case 2:
                    jeu2.MainJeu2.main(null);
                    break;
                case 3:
                    jeu3.Main.main(null);
                    break;
                case 4:
                    jeu4.Main.main(null);
                    break;
                case 5:
                    jeu5.Main.main(null);
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);

        scanner.close();
    }
}