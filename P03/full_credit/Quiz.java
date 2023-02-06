import java.util.Scanner;

public class Quiz {
    private Question[] questions = new Question[2];

    public Quiz(){
        loadQuiz();
    }

    public double takeQuiz(){
        Scanner in = new Scanner(System.in);
        int correctAnswers = 0;
        for (Question question : questions) {
            System.out.print(question);
            System.out.print("\n\n  Your Answer? ");
            int proposedAnswer = in.nextInt();
            if (question.checkAnswer(proposedAnswer) == true) {correctAnswers++;}
        }
        in.close();
        return ((double)correctAnswers / (double)questions.length);
    }

    private void loadQuiz(){
        String[] q1Ans = {"200", "206", "208", "202"};
        Question q1 = new Question("How many bones are in the human body?", q1Ans, 2);
    
        String[] q2Ans = {"6", "7", "3", "1"};
        Question q2 = new Question("How many points is a touchdown worth?", q2Ans, 1);
    
        questions[0] = q1;
        questions[1] = q2;
    }
}
