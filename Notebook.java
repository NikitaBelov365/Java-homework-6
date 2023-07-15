import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notebook {
    int id;
    int serialNumber;
    String modelName;
    String manufactorersName;
    String color;
    String operatingSystem;
    int screenDiagonal;
    int price;
    int hardDriveVolume;
    int RAM;

    public static int idAppropriator() {
        try {
            File file = new File("C:/Users/Н/Edu/Java/homework/6/notebookDB.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            String lastLine = null;
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }
            String[] parts = lastLine.split(",");
            int firstNumber = Integer.parseInt(parts[0]);
            br.close();

            return firstNumber + 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void notebookAdding(int serialNumber, String modelName, String manufactorersName, String color,
            String operatingSystem, int screenDiagonal, int price, int hardDriveVolume, int RAM) {
        this.serialNumber = serialNumber;
        this.modelName = modelName;
        this.manufactorersName = manufactorersName;
        this.color = color;
        this.operatingSystem = operatingSystem;
        this.screenDiagonal = screenDiagonal;
        this.price = price;
        this.hardDriveVolume = hardDriveVolume;
        this.RAM = RAM;

        try (FileWriter writer = new FileWriter("notebookDB.txt", true)) {
            writer.write(
                    idAppropriator() + ", serial = " + serialNumber + ", " + modelName + ", " + manufactorersName + ", "
                            + color + ", " + operatingSystem + ", Diagonal = " + screenDiagonal + ", price = " + price
                            + ", HDD = " + hardDriveVolume
                            + ", RAM =" + RAM + "\n");

            writer.flush();
            System.out.println("model added successfully");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


}
