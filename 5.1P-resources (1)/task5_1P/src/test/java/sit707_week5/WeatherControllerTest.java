package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemps;
    private static int nHours;

    @BeforeClass
    public static void setUp() {
        System.out.println("+++ setUp +++");

        wController = WeatherController.getInstance();
        nHours = wController.getTotalHours();
        hourlyTemps = new double[nHours];

        for (int i = 0; i < nHours; i++) {
            hourlyTemps[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("+++ tearDown +++");
        wController.close();
    }

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
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        double minTemperature = hourlyTemps[0];

        for (double temp : hourlyTemps) {
            if (temp < minTemperature) {
                minTemperature = temp;
            }
        }

        double cachedMin = wController.getTemperatureMinFromCache();

        Assert.assertTrue(cachedMin == minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        double maxTemperature = hourlyTemps[0];

        for (double temp : hourlyTemps) {
            if (temp > maxTemperature) {
                maxTemperature = temp;
            }
        }

        double cachedMax = wController.getTemperatureMaxFromCache();

        Assert.assertTrue(cachedMax == maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        double sumTemp = 0;

        for (double temp : hourlyTemps) {
            sumTemp += temp;
        }

        double averageTemp = sumTemp / nHours;
        double cachedAverage = wController.getTemperatureAverageFromCache();

        Assert.assertTrue(cachedAverage == averageTemp);
    }

    @Test
    public void testTemperaturePersist() throws Exception {
        System.out.println("+++ testTemperaturePersist +++");

        long beforeTime = System.currentTimeMillis();

        String persistTime = wController.persistTemperature(10, 19.5);

        long afterTime = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
        Date persistDate = sdf.parse(persistTime);

        Calendar currentCal = Calendar.getInstance();
        Calendar persistCal = Calendar.getInstance();
        persistCal.setTime(persistDate);

        currentCal.set(Calendar.HOUR_OF_DAY, persistCal.get(Calendar.HOUR_OF_DAY));
        currentCal.set(Calendar.MINUTE, persistCal.get(Calendar.MINUTE));
        currentCal.set(Calendar.SECOND, persistCal.get(Calendar.SECOND));
        currentCal.set(Calendar.MILLISECOND, 0);

        long persistMillis = currentCal.getTimeInMillis();

        Assert.assertTrue(
            "Persist time should be between before and after execution time",
            persistMillis >= beforeTime - 1000 && persistMillis <= afterTime + 1000
        );
    }
}