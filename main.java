import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what do you want to do?");
        System.out.println("Type 1 to add new notebook");
        System.out.println("Type 2 to search for notebook");
        System.out.println("");
        int operation = scanner.nextInt();
        switch (operation) {
            case 1 -> {
                System.out.println("Entering adding mode");
                notebookCreating();
                break;
            }
            case 2 -> {
                System.out.println("Entering searching mode");
                notebookSearching();
                break;
            }
            default -> {
                System.out.println("Wrong choise");
            }
        }
        scanner.close();
    }

    public static void notebookCreating() {
        Notebook notebook = new Notebook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input serial number: ");
        int serialNumber = scanner.nextInt();
        System.out.println("Input model name: ");
        String modelName = scanner.nextLine();
        System.out.println("Input manufactorer's Name: ");
        String manufactorersName = scanner.nextLine();
        System.out.println("Input color: ");
        String color = scanner.nextLine();
        System.out.println("Input OS: ");
        String operatingSystem = scanner.nextLine();
        System.out.println("Input screen diagonal: ");
        int screenDiagonal = scanner.nextInt();
        System.out.println("Input price: ");
        int price = scanner.nextInt();
        System.out.println("Input hard drive volume (GB): ");
        int hardDriveVolume = scanner.nextInt();
        System.out.println("Input RAM volume (GB): ");
        int RAM = scanner.nextInt();
        scanner.close();
        notebook.notebookAdding(serialNumber, modelName, manufactorersName, color, operatingSystem, screenDiagonal,
                price, hardDriveVolume, RAM);
    }

    public static void notebookSearching() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you need to find?");
        System.out.println("Press 1 for notebook model");
        System.out.println("Press 2 for notebook manufacturer");
        System.out.println("Press 3 for notebook color");
        System.out.println("Press 4 for notebook OS");
        System.out.println("Press 5 for notebook screen diagonal");
        System.out.println("Press 6 for notebook price");
        System.out.println("Press 7 for notebook HDD volume");
        System.out.println("Press 8 for notebook RAM volume");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> {
                System.out.println("Entering adding mode");
                break;
            }
            case 2 -> {
                System.out.println("Igfor");
            }
        }
        scanner.close();
    }
}
