package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopUtilsTest {

    @Test
    public void testSumToNMultipleLoopRuns() {
        Assert.assertEquals(15, LoopUtils.sumToN(5));
    }

    @Test
    public void testSumToNOneLoopRun() {
        Assert.assertEquals(1, LoopUtils.sumToN(1));
    }

    @Test
    public void testSumToNZeroLoopRun() {
        Assert.assertEquals(0, LoopUtils.sumToN(0));
    }

    @Test
    public void testCountEvenNumbersNormalCase() {
        Assert.assertEquals(3, LoopUtils.countEvenNumbers(6));
    }

    @Test
    public void testCountEvenNumbersOne() {
        Assert.assertEquals(0, LoopUtils.countEvenNumbers(1));
    }

    @Test
    public void testCountEvenNumbersZero() {
        Assert.assertEquals(0, LoopUtils.countEvenNumbers(0));
    }
}