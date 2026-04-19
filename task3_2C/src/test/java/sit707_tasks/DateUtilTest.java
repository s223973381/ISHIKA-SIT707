package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Equivalence class testing for DateUtil.
 * @author Ishika Mandal
 */
public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s223973381";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Ishika Mandal";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // D1 + M2 + Y1: Normal day in 31-day month, non-leap year
    @Test
    public void testNormalDayIn31DayMonthShouldIncrementNormally() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("testNormalDayIn31DayMonthShouldIncrementNormally > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // D1 + M1 + Y1: Normal day in 30-day month, non-leap year
    @Test
    public void testNormalDayIn30DayMonthShouldIncrementNormally() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("testNormalDayIn30DayMonthShouldIncrementNormally > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // D1 + M3 + Y1: Normal day in February, non-leap year
    @Test
    public void testNormalDayInFebruaryNonLeapYearShouldIncrementNormally() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("testNormalDayInFebruaryNonLeapYearShouldIncrementNormally > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // D2 + M3 + Y2: Feb 29 in leap year is valid
    @Test
    public void testLeapYearFeb29ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("testLeapYearFeb29ShouldIncrementToMarch1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // D2 + M3 + Y1: Feb 29 in non-leap year is invalid
    @Test(expected = RuntimeException.class)
    public void testNonLeapYearFeb29ShouldBeInvalid() {
        new DateUtil(29, 2, 1994);
    }

    // D3 + M1 + Y1: Day 30 in a 30-day month is valid and transitions correctly
    @Test
    public void testDay30In30DayMonthShouldIncrementToNextMonth() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("testDay30In30DayMonthShouldIncrementToNextMonth > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // D3 + M3 + Y1: Feb 30 is invalid
    @Test(expected = RuntimeException.class)
    public void testDay30InFebruaryShouldBeInvalid() {
        new DateUtil(30, 2, 1994);
    }

    // D4 + M2 + Y1: Day 31 in a 31-day month is valid
    @Test
    public void testDay31In31DayMonthShouldIncrementToNextMonth() {
        DateUtil date = new DateUtil(31, 1, 1994);
        System.out.println("testDay31In31DayMonthShouldIncrementToNextMonth > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    // D4 + M1 + Y1: Day 31 in a 30-day month is invalid
    @Test(expected = RuntimeException.class)
    public void testDay31In30DayMonthShouldBeInvalid() {
        new DateUtil(31, 6, 1994);
    }

    // D4 + M2 + Y1 with year-end rollover
    @Test
    public void testDecember31ShouldIncrementToJanuary1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2023);
        System.out.println("testDecember31ShouldIncrementToJanuary1NextYear > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // Decrement representative case in leap year
    @Test
    public void testMarch1LeapYearShouldDecrementToFeb29() {
        DateUtil date = new DateUtil(1, 3, 2024);
        System.out.println("testMarch1LeapYearShouldDecrementToFeb29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // Decrement representative case in 30-day month
    @Test
    public void testJuly1ShouldDecrementToJune30() {
        DateUtil date = new DateUtil(1, 7, 1994);
        System.out.println("testJuly1ShouldDecrementToJune30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
}