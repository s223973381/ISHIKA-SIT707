package sit707_week5;

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

        // Arrange: initialise controller once
        wController = WeatherController.getInstance();
        nHours = wController.getTotalHours();
        hourlyTemps = new double[nHours];

        // Arrange: retrieve all hourly temperatures once only
        for (int i = 0; i < nHours; i++) {
            hourlyTemps[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("+++ tearDown +++");

        // After: close controller once only
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

        // Arrange
        double minTemperature = hourlyTemps[0];
        for (double temp : hourlyTemps) {
            if (temp < minTemperature) {
                minTemperature = temp;
            }
        }

        // Act
        double cachedMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertTrue(cachedMin == minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        double maxTemperature = hourlyTemps[0];
        for (double temp : hourlyTemps) {
            if (temp > maxTemperature) {
                maxTemperature = temp;
            }
        }

        // Act
        double cachedMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertTrue(cachedMax == maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        double sumTemp = 0;
        for (double temp : hourlyTemps) {
            sumTemp += temp;
        }
        double averageTemp = sumTemp / nHours;

        // Act
        double cachedAverage = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertTrue(cachedAverage == averageTemp);
    }

    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//      System.out.println("+++ testTemperaturePersist +++");
//
//      WeatherController wController = WeatherController.getInstance();
//
//      String persistTime = wController.persistTemperature(10, 19.5);
//      String now = new SimpleDateFormat("H:m:s").format(new Date());
//      System.out.println("Persist time: " + persistTime + ", now: " + now);
//
//      Assert.assertTrue(persistTime.equals(now));
//
//      wController.close();
    }
}