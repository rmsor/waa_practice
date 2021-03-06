/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
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

    private void genQuizPage(Quiz sessQuiz, PrintWriter out, String currQuest, boolean error, String answer) {

        out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form method='post'>");
        out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(sessQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print("[" + currQuest + ", <span style='color:red;font-weight:bold'>?</span> ] </p>");

        out.print("<p>Your answer:<input type='text' name='txtAnswer' value='' /></p> ");

        /* if incorrect, then print out error message */
        if (error && (answer != null)) {  //REFACTOR?-- assumes answer null only when first open page
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
        out.print("<p><input type='submit' name='btnNext' value='Next' /></p> ");

        out.print("</form>");
        out.print("</body></html>");
    }

    private void genQuizOverPage(PrintWriter out) {
        out.print("<html> ");
        out.print("<head >");
        out.print("<title>NumberQuiz is over</title> ");
        out.print("</head> ");
        out.print("<body> ");
        out.print("<p style='color:red'>The number quiz is over!</p>	</body> ");
        out.print("</html> ");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        s.setAttribute("quiz", new Quiz());
        Quiz q = (Quiz) s.getAttribute("quiz");
        PrintWriter out = response.getWriter();
        String currentQues = q.getCurrentQuestion();
        genQuizPage(q, out, currentQues, false, null);
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
        PrintWriter out = response.getWriter();
        if (q.getCurrentQuestionIndex() >= q.getNumQuestions()) {
            genQuizOverPage(out);
        } else {
            String currentQues = q.getCurrentQuestion();
            genQuizPage(q, out, currentQues, !isCorrect, answer);
        }
    }

}
