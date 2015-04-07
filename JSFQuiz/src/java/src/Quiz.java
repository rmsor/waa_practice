/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author 984317
 */
public class Quiz {
    private ArrayList<Question> questions=new ArrayList<Question>();
    private int numCorrect=0;
    private int currentQuestion=0;
    
    public Quiz(){
        questions.add(new Question("3,1,4,1,5","9","PI"));
        questions.add(new Question("1,1,2,3,5","8","Fibonnaci"));
        questions.add(new Question("1,4,9,16,25","36","Square"));
        questions.add(new Question("2,3,5,7,11","13","Increment"));
        questions.add(new Question("1,2,4,8,16","32","Double"));
    }
    public boolean isCorrect(String ans){
        return ans.equals(questions.get(currentQuestion).getAnswer());
    }
    public void scoreAnswer(){
        numCorrect++;
        currentQuestion++;
    }
    public int getNumCorrect(){
        return this.numCorrect;
    }
    
    public int getCurrentQuestionIndex(){
        return this.currentQuestion;
    }
    
    public String getCurrentQuestion(){
        return questions.get(currentQuestion).getQuestion();
    }
    public String getCorrectAns(){
        return questions.get(currentQuestion).getAnswer();
    }
    public String getQuestionHint(){
        return questions.get(currentQuestion).getHint();
    }
    
    public int getNumQuestions(){
        return questions.size();
    }
}
