package jeu5;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

                Question[] questions = {
                        new Question("ما هو عاصمة فرنسا؟", new String[]{"باريس", "مدريد", "لندن", "برلين"}, "باريس"),
                        new Question("كم عدد القارات على الأرض؟", new String[]{"7", "5", "6", "8"}, "7"),
                        new Question("ما هو الرمز الكيميائي للأوكسجين؟", new String[]{"O", "A", "H", "C"}, "O"),
                        new Question("من فاز بكأس العالم لكرة القدم عام 2014؟", new String[]{"ألمانيا", "الأرجنتين", "البرازيل", "إسبانيا"}, "ألمانيا"),
                        new Question("كم مرة فاز ليونيل ميسي بجائزة الكرة الذهبية حتى الآن؟", new String[]{"7", "5", "6", "8"}, "7"),
                        new Question("أي فريق فاز بالدوري الإنجليزي الممتاز في موسم 2020-2021؟", new String[]{"مانشستر سيتي", "ليفربول", "مانشستر يونايتد", "تشيلسي"}, "مانشستر سيتي"),
                        new Question("من هو أغلى لاعب في تاريخ كرة القدم من حيث التحويل؟", new String[]{"نيمار", "كيليان مبابي", "كريستيانو رونالدو", "جواو فيليكس"}, "نيمار"),
                        new Question("أي فريق فاز بكأس أمريكا 2019؟", new String[]{"البرازيل", "الأرجنتين", "الأوروغواي", "تشيلي"}, "البرازيل")

                };

                Quiz quiz = new Quiz(questions, 2);
                quiz.start();

    }
}