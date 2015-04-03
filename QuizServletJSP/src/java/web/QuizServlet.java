/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.Quiz;

/**
 *
 * @author 984317
 */
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        s.setAttribute("quiz", new Quiz());
        Quiz q = (Quiz) s.getAttribute("quiz");
        String currentQues = q.getCurrentQuestion();
        request.setAttribute("currentScore", q.getNumCorrect());
        request.setAttribute("currentQues", currentQues);
        request.setAttribute("error", false);
        request.setAttribute("answer", null);
        request.setAttribute("errorValidation", false);
        RequestDispatcher view = request.getRequestDispatcher("quiz.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        Quiz q = (Quiz) s.getAttribute("quiz");
        String answer = (String) request.getParameter("txtAnswer");

        Boolean isCorrect = q.isCorrect(answer);
        if (isCorrect) {
            q.scoreAnswer();
        }
        String currentQues = q.getCurrentQuestion();
        request.setAttribute("currentScore", q.getNumCorrect());
        request.setAttribute("currentQues", currentQues);
        request.setAttribute("error", !isCorrect);
        request.setAttribute("answer", answer);
        request.setAttribute("errorValidation", false);
        String page = "";
        if (!isValidInteger(answer)) {
            request.setAttribute("errorValidation", true);
            request.setAttribute("error", false);
            page = "quiz.jsp";
        } else if (q.getCurrentQuestionIndex() >= q.getNumQuestions()) {
            page = "over.jsp";

        } else {
            page = "quiz.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);
    }

    public boolean isValidInteger(String str) {
        try {
            int inp = Integer.parseInt(str);
            if (inp > 100 || inp < 4) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
