import java.util.Scanner;

public class QuizApplicationWithTimer {
    private static final String[][] QUESTIONS = {
            {"What is the capital of France?", "A. Paris", "B. Rome", "C. Madrid", "A"},
            {"Which planet is known as the Red Planet?", "A. Mars", "B. Venus", "C. Jupiter", "A"},
            {"What is the largest mammal?", "A. Elephant", "B. Blue whale", "C. Giraffe", "B"}
    };

    private static final int QUESTION_TIME_LIMIT = 10; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (String[] question : QUESTIONS) {
            System.out.println(question[0]);
            for (int i = 1; i < question.length - 1; i++) {
                System.out.println(question[i]);
            }

            String correctAnswer = question[question.length - 1];
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();

            while (!userAnswer.equals("A") && !userAnswer.equals("B") && !userAnswer.equals("C")) {
                System.out.println("Invalid input. Please enter A, B, or C.");
                System.out.print("Your answer: ");
                userAnswer = scanner.nextLine().toUpperCase();
            }

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswer);
            }

            try {
                Thread.sleep(QUESTION_TIME_LIMIT * 1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(); 

        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your final score is: " + score + "/" + QUESTIONS.length);
        scanner.close();
    }
}
