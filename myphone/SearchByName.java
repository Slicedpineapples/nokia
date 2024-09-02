import java.io.File;
import java.util.Scanner;

public class SearchByName {   

    public static void searchByName(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        name = scanner.nextLine().toLowerCase().strip();
        String[] phoneNumbers = new String[10]; // Allow for a maximum of 10 phone numbers per subscriber
        if (name.equals("")) {
            System.out.println("Null input");
        } else {
            try {
                File file = new File("phoneBook.txt");
                Scanner filescanner = new Scanner(file);
                String currentLine;
                int count = 0;

                while (filescanner.hasNextLine()) {
                    currentLine = filescanner.nextLine();
                    if (currentLine.substring(0, currentLine.indexOf(":")).equals(name)) {
                        String phoneNumber = currentLine.substring(currentLine.indexOf(":") + 2);
                        phoneNumbers[count] = phoneNumber;
                        count++;
                    }
                }
                filescanner.close();

                if (count == 0) {
                    throw new Exception("User not found");
                } else {
                    System.out.println("Phone numbers belonging to: " + name.substring(0, 1).toUpperCase() + name.substring(1));
                    for (int i = 0; i < count; i++) {
                        System.out.println(phoneNumbers[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}