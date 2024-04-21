package jeu2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessCountry {
    private ArrayList<Country> easyCountries;
    private ArrayList<Country> mediumCountries;
    private ArrayList<Country> hardCountries;
    private Random random;
    private Scanner scanner;
    private int score;
    private String playerName;

    public GuessCountry() {
        initializeCountries();
        random = new Random();
        scanner = new Scanner(System.in);
        score = 0;
        playerName = "";
    }

    private void initializeCountries() {
        easyCountries = new ArrayList<>();
        mediumCountries = new ArrayList<>();
        hardCountries = new ArrayList<>();

        // Easy Level Countries
        easyCountries.add(new Country("فرنسا", "أوروبا", "باريس", "الفرنسية", 68000000, "551،695 كم²"));
        easyCountries.add(new Country("ألمانيا", "أوروبا", "برلين", "الألمانية", 83000000, "357،022 كم²"));
        easyCountries.add(new Country("إيطاليا", "أوروبا", "روما", "الإيطالية", 60483973, "301،340 كم²"));
        easyCountries.add(new Country("إسبانيا", "أوروبا", "مدريد", "الإسبانية", 46733038, "505،990 كم²"));
        easyCountries.add(new Country("المملكة المتحدة", "أوروبا", "لندن", "الإنجليزية", 67886004, "243،610 كم²"));
        easyCountries.add(new Country("الصين", "آسيا", "بكين", "الصينية", 1403500365, "9،596،961 كم²"));
        easyCountries.add(new Country("الولايات المتحدة", "أمريكا الشمالية", "واشنطن العاصمة", "الإنجليزية", 331449281, "9،833،520 كم²"));

        // Medium Level Countries
        mediumCountries.add(new Country("اليابان", "آسيا", "طوكيو", "اليابانية", 122000000, "377،975 كم²"));
        mediumCountries.add(new Country("البرازيل", "أمريكا الجنوبية", "برازيليا", "البرتغالية", 213993437, "8،515،767 كم²"));
        mediumCountries.add(new Country("المكسيك", "أمريكا الشمالية", "مكسيكو سيتي", "الإسبانية", 126190788, "1،964،375 كم²"));
        mediumCountries.add(new Country("روسيا", "أوروبا/آسيا", "موسكو", "الروسية", 146599183, "17،098،242 كم²"));
        mediumCountries.add(new Country("أستراليا", "أوقيانوسيا", "كانبرا", "الإنجليزية", 257883197, "7،692،024 كم²"));
        mediumCountries.add(new Country("جنوب أفريقيا", "أفريقيا", "بريتوريا", "الأفريكانية", 59308690, "1،221،037 كم²"));
        mediumCountries.add(new Country("الأرجنتين", "أمريكا الجنوبية", "بوينس آيرس", "الإسبانية", 45605812, "2،780،400 كم²"));


        // Hard Level Countries
        hardCountries.add(new Country("كندا", "أمريكا الشمالية", "أوتاوا", "الإنجليزية والفرنسية", 37961548, "9،984،670 كم²"));
        hardCountries.add(new Country("الهند", "آسيا", "نيودلهي", "الهندية والإنجليزية", 1380004385, "3،287،263 كم²"));
        hardCountries.add(new Country("إندونيسيا", "آسيا", "جاكرتا", "الإندونيسية", 276361783, "1،904،569 كم²"));
        hardCountries.add(new Country("نيجيريا", "أفريقيا", "أبوجا", "الإنجليزية", 206139587, "923،768 كم²"));
        hardCountries.add(new Country("المملكة العربية السعودية", "آسيا", "الرياض", "العربية", 34813871, "2،149،690 كم²"));
        hardCountries.add(new Country("مصر", "أفريقيا", "القاهرة", "العربية", 104258327, "1،010،408 كم²"));
        hardCountries.add(new Country("ألمانيا", "أوروبا", "برلين", "الألمانية", 83000000, "357،022 كم²"));
    }
    private void getPlayerName() {
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        System.out.println("Hello Champion!");
    }

    private void RandomCountry(ArrayList<Country> list) {
        int index = random.nextInt(list.size());
        Country selectedCountry = list.get(index);
        System.out.println("Guess the country based on :");
        System.out.println("Continent : " + selectedCountry.getContinent());

        if (list == easyCountries) {
            System.out.println("Help: Language is " + selectedCountry.getOfficialLanguage());
        } else if (list == mediumCountries) {
            System.out.println("Help: Capital is " + selectedCountry.getCapital() + ", Population is " + selectedCountry.getPopulation());
        } else {
         System.out.println("Help: Capital is " + selectedCountry.getCapital() + ", Language is " + selectedCountry.getOfficialLanguage());
        }

        System.out.print("Your answer : ");
        String guess = scanner.nextLine();

        if (guess.equalsIgnoreCase(selectedCountry.getName())) {
            System.out.println("Congratulations, " + playerName + "! You guessed the country correctly: " + selectedCountry.getName());
            if (list == easyCountries) score += 1;
            else if (list == mediumCountries) score += 2;
            else if (list == hardCountries) score += 3;
        } else {
            System.out.println("Sorry, " + playerName + ", the correct answer was: " + selectedCountry.getName());
        }

        System.out.println("Your current score: " + score);
    }

    public void play() {
        getPlayerName(); 
        while (score < 10) {
            System.out.println("Choose the difficulty level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                RandomCountry(easyCountries);
                    break;
                case 2:
                RandomCountry(mediumCountries);
                    break;
                case 3:
                RandomCountry(hardCountries);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }

        System.out.println("Congratulations, " + playerName + "! We have a winner");
        scanner.close();
    }

}
