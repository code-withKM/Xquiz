package crio.xquiz;

import java.util.List;

public class  Question{

    String questionText;
    String answer;
    List<String> choices;


    public Question(String questionText,List<String> choices,String answer){

        if (questionText == null || questionText.isEmpty()) {
            System.out.println("Question text cannot be null or empty!");
        } else if (answer == null || answer.isEmpty()) {
            System.out.println("Answer cannot be null or empty!");
        }else if(choices == null || choices.isEmpty()){
            System.out.println("Choices cannot be null or empty!");
        } else if (!choices.contains(answer)) { 
            System.out.println("Answer is not present among the choices!");
        }else{
            this.questionText = questionText;
            this.answer = answer;
            this.choices = choices;
        }
       
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getChoices() {
        return choices;
    }

    public boolean checkAnswer(String answer){
        if (this.answer.equals(answer)) {
            return true;
        } else {
            return false;
        }
       
    }

    public void display(){
        System.out.println(getQuestionText());
        for(int i = 0; i < choices.size(); i++){
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ":" + choices.get(i));
        }
    }
    public static void main(String[] args) {
  
    }
}