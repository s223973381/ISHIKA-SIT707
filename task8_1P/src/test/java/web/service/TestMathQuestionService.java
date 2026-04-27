package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // ✅ Q1 Addition Tests
    @Test
    public void testQ1AdditionValid() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.001);
    }

    @Test
    public void testQ1AdditionEmptyInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "2")));
    }

    @Test
    public void testQ1AdditionInvalidInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("abc", "2")));
    }

    // ✅ Q2 Subtraction Tests
    @Test
    public void testQ2SubtractionValid() {
        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0.001);
    }

    @Test
    public void testQ2SubtractionInvalid() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("", "2")));
    }

    // ✅ Q3 Multiplication Tests
    @Test
    public void testQ3MultiplicationValid() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0.001);
    }

    @Test
    public void testQ3MultiplicationInvalid() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("abc", "3")));
    }
}