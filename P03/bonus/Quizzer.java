public class Quizzer {
    public static void main(String[] args){
        try {
            Quiz quiz = new Quiz();
            double score = quiz.takeQuiz();
            System.out.println("\nYour grade is " + (score * 100));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
