import java.io.*;
import java.util.Scanner;

public class WeatherReader {
    /*
 Step 1: Method to check if the file exists, if file does not exists it throws and
 will throw a WeatherFileNotFoundException
 */
    public void checkFileExists(File file) throws WeatherFileNotFoundException {
       if(!file.exists()) {
           throw new WeatherFileNotFoundException();
       }

    };
    /*
    Step 2: Method to read file using Scanner methods and display the file content
    In this method catch the FileNotFoundException only
    */
    public void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            System.out.println("\n Reading weather data from file:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                System.out.println( line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

            // Reading file line by line and display each line

    /*
    Step 3: Method to process the file by combining both tasks.
    In this method catch the WeatherFileNotFoundException only
    */
    public void processWeatherFile(String filePath) {
        try {

                // Step 1: Create File object to assign filePath
                File file = new File(filePath);
                // Step 2: Check file existence
                this.checkFileExists(file);
                // Step 3: Read the file
                this.readFile(file);
                this.readFileAsBytes(filePath);
                this.writeFileAsBytes(filePath,"Saturday:Foggy \n Sunday: Rainy");
                this.readFile(file);

        }
        catch (WeatherFileNotFoundException e) {
            System.out.println( e.getMessage());
            e.printStackTrace();

        }
    }
    // Method to read a file as a byte stream- FileInputStream
    //Make sure to include the IOException and printStackTrace() in the catch
    //block.
    public void readFileAsBytes(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            //String path;
            if (filePath != null && filePath.equalsIgnoreCase(filePath)) {
                System.out.println("\n Reading file as bytes:");
                int i = 0;
                while ((i = fis.read()) != -1) {
                    System.out.print((char) i);

                }
            }
        }
        catch (IOException e) {
            System.out.println( e.getMessage());
            e.printStackTrace();
        }

    }
    // Method to write data to a file as a byte stream- FileOutputStream
    //Make sure to include the IOException and printStackTrace() in the catch block.
    public  void writeFileAsBytes(String filePath, String content) {
        //try (FileOutputStream fos = new FileOutputStream(filePath)) {
        try  {
            FileOutputStream fos = new FileOutputStream(filePath);
            if (filePath != null && filePath.equalsIgnoreCase(filePath)) {
                System.out.println(" \n Content written to file successfully as bytes: ");
                byte[] bytes = content.getBytes();
                fos.write(bytes);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public  String getFileNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Enter file name (with path) : " );
        return scanner.nextLine();
    }

}





