package jeu4;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello in our game CHAMPION !! ");
    Joueur joueur = new JoueurHumain();
    JeuMotMelange jeu = new JeuMotMelange(joueur);
    jeu.jouer();
}
}
