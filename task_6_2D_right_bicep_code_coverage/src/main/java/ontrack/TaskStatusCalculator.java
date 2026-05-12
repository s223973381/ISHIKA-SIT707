package ontrack;

import java.time.LocalDate;

public class TaskStatusCalculator {

    public String calculateTaskStatus(LocalDate submissionDate, LocalDate dueDate, boolean feedbackGiven) {

        if (dueDate == null) {
            return "Invalid due date";
        }

        if (submissionDate == null) {
            return "Not submitted";
        }

        if (feedbackGiven) {
            return "Marked";
        }

        if (submissionDate.isAfter(dueDate)) {
            return "Submitted late - waiting for feedback";
        }

        if (submissionDate.isEqual(dueDate)) {
            return "Submitted on due date - waiting for feedback";
        }

        return "Submitted on time - waiting for feedback";
    }
}