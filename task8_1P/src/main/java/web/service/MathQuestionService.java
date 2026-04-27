package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result: addition.
     * Returns Double.NaN if input is empty, null, or not numeric.
     *
     * @param number1 first number as String
     * @param number2 second number as String
     * @return addition result or Double.NaN for invalid input
     */
    public static double q1Addition(String number1, String number2) {
        if (isInvalid(number1) || isInvalid(number2)) {
            return Double.NaN;
        }
        return Double.valueOf(number1) + Double.valueOf(number2);
    }

    /**
     * Calculate Q2 result: subtraction.
     * Returns Double.NaN if input is empty, null, or not numeric.
     *
     * @param number1 first number as String
     * @param number2 second number as String
     * @return subtraction result or Double.NaN for invalid input
     */
    public static double q2Subtraction(String number1, String number2) {
        if (isInvalid(number1) || isInvalid(number2)) {
            return Double.NaN;
        }
        return Double.valueOf(number1) - Double.valueOf(number2);
    }

    /**
     * Calculate Q3 result: multiplication.
     * Returns Double.NaN if input is empty, null, or not numeric.
     *
     * @param number1 first number as String
     * @param number2 second number as String
     * @return multiplication result or Double.NaN for invalid input
     */
    public static double q3Multiplication(String number1, String number2) {
        if (isInvalid(number1) || isInvalid(number2)) {
            return Double.NaN;
        }
        return Double.valueOf(number1) * Double.valueOf(number2);
    }

    /**
     * Checks whether input is invalid for math calculation.
     */
    private static boolean isInvalid(String value) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }

        try {
            Double.valueOf(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
