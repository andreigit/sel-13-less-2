package test;

public class SettingsProvider {

    private static final String START_XAMPP_EXE = "C:\\xampp\\xampp_start.exe";

    private static final String STOP_XAMPP_EXE = "C:\\xampp\\xampp_stop.exe";

    public static String getRunServerString() {
        return START_XAMPP_EXE;
    }

    public static String getStopServerString() {
        return STOP_XAMPP_EXE;
    }
}
