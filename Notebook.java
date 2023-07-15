import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
                            + ", RAM = " + RAM + "\n");

            writer.flush();
            System.out.println("model added successfully");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void searchSplitter(int i) {
        if (i < 5) {
            notebookStringSearch(i);
        } else {
            notebookIntegerSearch(i);
        }
    }

    public void notebookIntegerSearch(int i) {
        i = i + 1;
        System.out.println("Input minimum value: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        try {
            File file = new File("C:/Users/Н/Edu/Java/homework/6/notebookDB.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            System.out.println("We got next options: ");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String[] part = parts[i].split("=");
                
                if (number < Integer.parseInt(part[1].trim())) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notebookStringSearch(int i) {
        try {
            Set<String> mySet = new TreeSet<>();
            i = i + 1;
            File file = new File("C:/Users/Н/Edu/Java/homework/6/notebookDB.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            System.out.println("We got next options: ");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                mySet.add(parts[i]);
            }
            HashMap<Integer, String> myHashMap = new HashMap<>();
            int j = 1;
            for (String string : mySet) {
                myHashMap.put(j, string);
                j++;
            }
            System.out.println(myHashMap.toString());
            System.out.println("Input number that you intrested in: ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            BufferedReader brr = new BufferedReader(new FileReader(file));
            System.out.println("Here you are: ");
            String lines = null;
            String lookingFor = myHashMap.get(number);
            while ((lines = brr.readLine()) != null) {
                String[] part = lines.split(",");

                if (lookingFor.equals(part[i])) {
                    System.out.println(lines);
                }
            }
            scanner.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
