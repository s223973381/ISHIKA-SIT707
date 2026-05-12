package ontrack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskStatusCalculatorTest {

    private TaskStatusCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TaskStatusCalculator();
    }

    @Test
    void testNotSubmittedWhenSubmissionDateIsNull() {
        String result = calculator.calculateTaskStatus(null, LocalDate.of(2026, 5, 10), false);
        assertEquals("Not submitted", result);
    }

    @Test
    void testInvalidDueDateWhenDueDateIsNull() {
        String result = calculator.calculateTaskStatus(LocalDate.of(2026, 5, 9), null, false);
        assertEquals("Invalid due date", result);
    }

    @Test
    void testMarkedWhenFeedbackGiven() {
        String result = calculator.calculateTaskStatus(
                LocalDate.of(2026, 5, 9),
                LocalDate.of(2026, 5, 10),
                true
        );
        assertEquals("Marked", result);
    }

    @Test
    void testSubmittedLateWaitingForFeedback() {
        String result = calculator.calculateTaskStatus(
                LocalDate.of(2026, 5, 11),
                LocalDate.of(2026, 5, 10),
                false
        );
        assertEquals("Submitted late - waiting for feedback", result);
    }

    @Test
    void testSubmittedOnDueDateWaitingForFeedback() {
        String result = calculator.calculateTaskStatus(
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 10),
                false
        );
        assertEquals("Submitted on due date - waiting for feedback", result);
    }

    @Test
    void testSubmittedOnTimeWaitingForFeedback() {
        String result = calculator.calculateTaskStatus(
                LocalDate.of(2026, 5, 8),
                LocalDate.of(2026, 5, 10),
                false
        );
        assertEquals("Submitted on time - waiting for feedback", result);
    }
    @Test
    void testPerformanceWithRepeatedStatusCalculation() {

        for (int i = 0; i < 1000; i++) {

            String result = calculator.calculateTaskStatus(
                    LocalDate.of(2026, 5, 8),
                    LocalDate.of(2026, 5, 10),
                    false
            );

            assertEquals("Submitted on time - waiting for feedback", result);
        }
    }
}