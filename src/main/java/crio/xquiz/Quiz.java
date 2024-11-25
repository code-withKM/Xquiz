package crio.xquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private String quizName;
    private List<Question> questions;
    private int finalScore;

    public Quiz(String quizName){
        if(quizName == null || quizName.isEmpty()){
            System.out.println("Quiz Name cannot be null or empty!");
        }else{
            this.quizName = quizName;
            this.questions = new ArrayList<>();
            this.finalScore =0;
        }
    }
    public String getQuizName() {
        return quizName;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }
    
    public int getFinalScore() {
        return finalScore;
    }


    public void addQuestion(Question question) {
        if(question == null){
            System.out.println("Question cannot be null!");
        } else {
            questions.add(question);
        }
    }

    public void attemptQuiz(){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<questions.size();++i){ //Iterates over the list of Questions
            questions.get(i).display(); //Displays the question along with the list of choices
            int opt = sc.nextInt(); //Takes in the user input and stores it in integer variable `opt`
            if(opt<1 || opt>questions.get(i).getChoices().size()){ 
                //checks if the choice provided by user does not lie in the range of the list of choices
                System.out.println("Please choose a number between 1 and " + questions.get(i).getChoices().size());
                // asks the user to choose a number between given range
                i--; // the value of i is decremented so that the previous question comes again in the loop and is printed
            } else if (questions.get(i).checkAnswer(questions.get(i).getChoices().get(opt-1))){
                //else if option lies within the range, then it is checked whether the provided answer is correct
                // if provided answer is correct then the finalScore value is incremented by 1
                finalScore++;
            }
        }
        sc.close(); //after all the questions are attempted Scanner class instance is closed.
    }
    
}
