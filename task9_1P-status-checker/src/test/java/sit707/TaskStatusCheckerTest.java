package sit707;

import org.junit.Assert;
import org.junit.Test;

public class TaskStatusCheckerTest {

    @Test
    public void testNotStartedStatus() {
        String result = TaskStatusChecker.checkStatus("not started");
        Assert.assertEquals(
            "Task has not been started yet. Please begin the task.",
            result
        );
    }
    
    @Test
    public void testWorkingOnItStatus() {
        Assert.assertEquals(
            "Task is currently in progress. Keep working on it.",
            TaskStatusChecker.checkStatus("working on it")
        );
    }

    @Test
    public void testNeedHelpStatus() {
        Assert.assertEquals(
            "Student needs help. Please contact the tutor.",
            TaskStatusChecker.checkStatus("need help")
        );
    }
    @Test
    public void testReadyForFeedbackStatus() {
        Assert.assertEquals(
            "Task is ready for tutor feedback.",
            TaskStatusChecker.checkStatus("ready for feedback")
        );
    }

    @Test
    public void testReviewedStatus() {
        Assert.assertEquals(
            "Task has been reviewed successfully.",
            TaskStatusChecker.checkStatus("reviewed")
        );
    }

    @Test
    public void testResubmitStatus() {
        Assert.assertEquals(
            "Task needs changes. Please update and resubmit.",
            TaskStatusChecker.checkStatus("resubmit")
        );
    }

    @Test
    public void testDeadlineMissedStatus() {
        Assert.assertEquals(
            "Deadline has been missed. Please contact the tutor.",
            TaskStatusChecker.checkStatus("deadline missed")
        );
    }
}