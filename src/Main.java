import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherReader reader = new WeatherReader();
        String path = reader.getFileNameFromUser();
        reader.processWeatherFile(path);

   }
}








