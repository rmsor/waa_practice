/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import src.Quiz;

/**
 *
 * @author 984317
 */
@Named("QuizJSF")
@SessionScoped
public class QuizJSF implements Serializable {

    Quiz myQuiz;
    String txtAnswer;
    String msg;
    int noOfTries = 0;

    public QuizJSF() {
        myQuiz = new Quiz();
    }

    public Quiz getMyQuiz() {
        return myQuiz;
    }

    public String getTxtAnswer() {
        return txtAnswer;
    }

    public String getMsg() {
        return msg;
    }

    public int getNoOfTries() {
        return noOfTries;
    }

    public void setTxtAnswer(String txtAnswer) {
        this.txtAnswer = txtAnswer;
    }

    public String checkAnswer() {
        String page = "quiz";
        msg = "";
        if (!isValidInteger(txtAnswer)) {
            msg = "Input must be integer between 4 and 100! Please try again";
        } else {
            Boolean isCorrect = myQuiz.isCorrect(txtAnswer);
            if (isCorrect) {
                myQuiz.scoreAnswer();
                noOfTries = 0;
            } else {
                if(noOfTries<3){
                    noOfTries++;
                }
                if (noOfTries >= 3) {
                    msg = "You have Exceded The 3 number of tries. Correct Answer is: " + myQuiz.getCorrectAns();
                } else {
                    msg = "Your last answer was not correct! Please try again";                    
                }
            }
        }
        if (myQuiz.getCurrentQuestionIndex() >= myQuiz.getNumQuestions()) {
            page = "over";
        }
        txtAnswer = "";
        return page;

    }

    private boolean isValidInteger(String str) {
        try {
            if (str.equals("")) {
                return false;
            }
            int inp = Integer.parseInt(str);
            return !(inp > 100 || inp < 4);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
