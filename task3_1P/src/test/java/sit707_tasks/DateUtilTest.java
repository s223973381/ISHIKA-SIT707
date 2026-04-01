package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
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
	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	
	@Test
	public void testJune1ShouldDecrementToMay31() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.decrement();
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune2ShouldDecrementToJune1() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.decrement();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune15ShouldDecrementToJune14() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune30ShouldDecrementToJune29() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.decrement();
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void testJune31ShouldBeInvalid() {
	    new DateUtil(31, 6, 1994);
	}

	@Test
	public void testJune1ShouldIncrementToJune2() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.increment();
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune2ShouldIncrementToJune3() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.increment();
	    Assert.assertEquals(3, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune15ShouldIncrementToJune16() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune30ShouldIncrementToJuly1() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJanuary15ShouldDecrementToJanuary14() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testFebruary15ShouldDecrementToFebruary14() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNovember15ShouldDecrementToNovember14() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testDecember15ShouldDecrementToDecember14() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJanuary15ShouldIncrementToJanuary16() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testFebruary15ShouldIncrementToFebruary16() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNovember15ShouldIncrementToNovember16() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testDecember15ShouldIncrementToDecember16() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testYear1700ShouldDecrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1700, date.getYear());
	}

	@Test
	public void testYear1701ShouldDecrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1701, date.getYear());
	}

	@Test
	public void testYear2023ShouldDecrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testYear2024ShouldDecrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.decrement();
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testYear1700ShouldIncrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1700, date.getYear());
	}

	@Test
	public void testYear1701ShouldIncrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1701, date.getYear());
	}

	@Test
	public void testYear2023ShouldIncrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testYear2024ShouldIncrementNormally() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearFeb28ShouldIncrementToFeb29() {
	    DateUtil date = new DateUtil(28, 2, 2024);
	    date.increment();
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearFeb29ShouldIncrementToMarch1() {
	    DateUtil date = new DateUtil(29, 2, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearMarch1ShouldDecrementToFeb29() {
	    DateUtil date = new DateUtil(1, 3, 2024);
	    date.decrement();
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test
	public void testLeapYearFeb29ShouldDecrementToFeb28() {
	    DateUtil date = new DateUtil(29, 2, 2024);
	    date.decrement();
	    Assert.assertEquals(28, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	@Test(expected = RuntimeException.class)
	public void testLeapYearFeb30ShouldBeInvalid() {
	    new DateUtil(30, 2, 2024);
	}
}
