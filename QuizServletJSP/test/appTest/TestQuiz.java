/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import src.Quiz;

/**
 *
 * @author 984317
 */
public class TestQuiz {
    
    Quiz quizUnderTest = new Quiz();
    
    public TestQuiz() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testIsCorrect() {
        /* should be at first question, answer should be "9" */
        assertTrue("first question answer should be '9'", quizUnderTest.isCorrect("9"));
    }

    @Test
    public void testGetNumberQuestions() {
        /* should be at first question, answer should be 5 */
        assertEquals(5, quizUnderTest.getNumQuestions());
    }

    @Test
    public void testGetNumberCorrect() {
        /* should be at first question, answer should be 0 */
        assertEquals(0, quizUnderTest.getNumCorrect());

        quizUnderTest.scoreAnswer(); //should increment the score and the current question number
        assertEquals(1, quizUnderTest.getNumCorrect());
        assertEquals(1, quizUnderTest.getCurrentQuestionIndex());

    }
}
