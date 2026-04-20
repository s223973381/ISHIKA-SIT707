package web.service;

public class LoginService {

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false;
        }

        if (username.trim().isEmpty() || password.trim().isEmpty() || dob.trim().isEmpty()) {
            return false;
        }

        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }

        return username.equals("Ishika")
                && password.equals("Ishika_M")
                && dob.equals("2001-10-03");
    }
}