import java.util.Scanner;

public class Quiz {
    private Question[] questions = new Question[5];

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
        String[] q1Ans = {"Composition", "Aggregation", "Inheritance", "Dependency"};
        Question q1 = new Question("Which UML Class Relationship is shown by an open diamond?", q1Ans, 2);
    
        String[] q2Ans = {"Composition", "Aggregation", "Inheritance", "Dependency"};
        Question q2 = new Question("Which UML Class Relationship is shown by a solid diamond?", q2Ans, 1);

        String[] q3Ans = {"String Concatenation", "StringBuilder"};
        Question q3 = new Question("Is it faster to use String Concatenation or StringBuilder?", q3Ans, 2);
    
        String[] q4Ans = {"System.out", "System.error", "System.err", "System.Debug"};
        Question q4 = new Question("How should we print errors to the system?", q4Ans, 3);

        String[] q5Ans = {"ArrayClass", "ArraySet", "ArrayGroup", "ArrayList"};
        Question q5 = new Question("What is the class version of array?", q5Ans, 4);
    
        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        questions[3] = q4;
        questions[4] = q5;
    }
}
