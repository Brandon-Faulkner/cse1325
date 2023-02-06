public class Question {
    private static int nextQuestionNumber = 1;
    private final int questionNumber;
    private String question;
    private String[] answers;
    private int rightAnswer;

    public Question(String question, String[] answers, int rightAnswer){
        if (rightAnswer < 1 || rightAnswer > answers.length) {
            throw new IllegalArgumentException("The number for the right answer that was provided was not in the bounds of the number of answers for this question.");
        }
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
        questionNumber = nextQuestionNumber++;
    }

    public boolean checkAnswer(int answer){     
        if(answer == rightAnswer){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        StringBuilder formedQuestion = new StringBuilder();
        formedQuestion.append("\n"+ questionNumber + ". " + question);

        int answerIndex = 1;
        for (String string : answers) {
            formedQuestion.append("\n  " + answerIndex + ") " + string);
            answerIndex++;
        }
        return formedQuestion.toString();
    }
}
