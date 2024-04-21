package jeu5;

import java.util.*;

class Quiz {
    private Question[] questions;
    private int jokers;
    private int score;
    private List<Integer> answeredQuestions;
    private Scanner scanner;
    static Timer timer = new Timer();
    private String userName; // Ajout de la variable pour stocker le nom de l'utilisateur

    public Quiz(Question[] questions, int jokers) {
        this.questions = questions;
        this.jokers = jokers;
        this.score = 0;
        this.answeredQuestions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Méthode pour saisir le nom de l'utilisateur
    private void getUserName() {
        System.out.print("Entrez votre nom : ");
        userName = scanner.nextLine();
    }

    public void start() {
        getUserName(); // Appel de la méthode pour saisir le nom de l'utilisateur
        System.out.println("Bienvenue dans le quiz, " + userName + "! Score: " + score); // Affichage du nom de l'utilisateur
        int questionNumber = 1;
        while (questionNumber <= questions.length ) {
            int currentQuestionIndex = getRandomQuestionIndex();
            if (!answeredQuestions.contains(currentQuestionIndex)) {
                Question currentQuestion = questions[currentQuestionIndex];
                System.out.println("jeu5.Question " + questionNumber + ": " + currentQuestion.getQuestion());
                String[] options = currentQuestion.getOptions();
                List<Integer> displayedOptionsIndices = new ArrayList<>();
                for (int i = 0; i < options.length; i++) {
                    displayedOptionsIndices.add(i);
                }
                Collections.shuffle(displayedOptionsIndices);
                for (int i = 0; i < displayedOptionsIndices.size(); i++) {
                    System.out.println((i + 1) + ". " + options[displayedOptionsIndices.get(i)]);
                }
                startTimer(10); // Démarrer le chronomètre
                int remainingTime = 10;

                while (remainingTime > 0) {
                    System.out.print("Temps restant : " + remainingTime + " secondes\r");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    remainingTime--;
                }
                System.out.println("Temps écoulé !");
                if (jokers > 0) {
                    System.out.println("Jokers restants: " + jokers);
                    System.out.println("1. Étendre le temps de réponse");
                    System.out.println("2. Éliminer deux fausses réponses");
                    System.out.print("Utiliser un joker (1 ou 2) ? Entrez 0 pour ne pas utiliser de joker : ");
                    int jokerChoice = scanner.nextInt();
                    scanner.nextLine(); // clear the buffer
                    if (jokerChoice == 1) {
                        extendTimeForAnswer();
                        jokers--;
                    } else if (jokerChoice == 2) {
                        eliminateTwoWrongAnswers(currentQuestion);
                        jokers--;
                    }
                }

                System.out.print("Entrez le numéro de votre réponse: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // clear the buffer
                String answer = options[displayedOptionsIndices.get(choice - 1)];
                if (answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
                    System.out.println("Bonne réponse !");
                    score += 10;
                } else {
                    System.out.println("Mauvaise réponse. La réponse correcte est : " + currentQuestion.getCorrectAnswer());
                }
                System.out.println("Votre score actuel est : " + score); // Affichage du score après chaque réponse
                questionNumber++;
                answeredQuestions.add(currentQuestionIndex);
                if (questionNumber <= questions.length) {
                    System.out.println("Appuyez sur Entrée pour passer à la question suivante...");
                    System.out.println("Si vous voulez taper exit");
                    String x=scanner.nextLine();
                    if (x.equalsIgnoreCase("exit")){
                        scanner.close();
                        break;
                    }else {
                        scanner.nextLine();
                    }


                }

            }
        }
        System.out.println("Votre score final est : " + score);
        scanner.close();
    }

    private int getRandomQuestionIndex() {
        Random random = new Random();
        int index = random.nextInt(questions.length);
        while (answeredQuestions.contains(index)) {
            index = random.nextInt(questions.length);
        }
        return index;
    }

    private void extendTimeForAnswer() {
        System.out.println("Temps de réponse étendu de 10 secondes.");
        Timer timer = new Timer();
        int[] count = {10}; // Compteur pour le chronomètre
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Temps restant : " + count[0] + " secondes");
                count[0]--;
                if (count[0] < 0) {
                    System.out.println("Temps écoulé !");
                    synchronized (scanner) {
                        scanner.notify();
                    }
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

        synchronized (scanner) {
            try {
                scanner.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void startTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = seconds;
            @Override
            public void run() {
                count--;
                if (count >= 0) {
                    System.out.print("Temps restant : " + count + " secondes\r");
                }
                if (count == 0) {
                    System.out.println("Temps écoulé !");
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    private void eliminateTwoWrongAnswers(Question question) {
        System.out.println("Deux fausses réponses ont été éliminées.");
        String[] options = question.getOptions();
        String correctAnswer = question.getCorrectAnswer();
        List<String> wrongAnswers = new ArrayList<>();
        for (String option : options) {
            if (!option.equalsIgnoreCase(correctAnswer)) {
                wrongAnswers.add(option);
            }
        }
        Collections.shuffle(wrongAnswers);
        System.out.println("Les réponses suivantes ont été éliminées : " + wrongAnswers.get(0) + ", " + wrongAnswers.get(1));
    }
}
