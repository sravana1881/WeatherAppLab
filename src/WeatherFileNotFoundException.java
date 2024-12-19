public class WeatherFileNotFoundException extends Exception {
    public WeatherFileNotFoundException() {
        super();
    }
    public WeatherFileNotFoundException(String message) {
        super("file not found: " + message);
    }
}
