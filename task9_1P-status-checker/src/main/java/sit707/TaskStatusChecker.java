package sit707;

public class TaskStatusChecker {

    public static String checkStatus(String status) {

        if (status == null) {
            return "Invalid status.";
        }

        switch (status.toLowerCase()) {

            case "not started":
                return "Task has not been started yet. Please begin the task.";

            case "working on it":
                return "Task is currently in progress. Keep working on it.";

            case "need help":
                return "Student needs help. Please contact the tutor.";
                
            case "ready for feedback":
                return "Task is ready for tutor feedback.";

            case "reviewed":
                return "Task has been reviewed successfully.";

            case "resubmit":
                return "Task needs changes. Please update and resubmit.";

            case "deadline missed":
                return "Deadline has been missed. Please contact the tutor.";    

            default:
                return "Invalid status.";
        }
    }
}