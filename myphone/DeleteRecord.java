import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class DeleteRecord {

    public static void deleteRecord(String name, String phoneNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to delete: ");
        name = scanner.nextLine().toLowerCase().strip();

        System.out.print("Enter phone number to delete: ");
        phoneNumber = scanner.nextLine();
        phoneNumber = phoneNumber.replaceAll("[\\s+]", "");
        System.out.println(phoneNumber);

        if (name.isEmpty() || phoneNumber.isEmpty()) {
            System.out.println("Null inputs");
        } else {
            try {
                // Check if the phone number is valid
                if (phoneVaildator.validPhoneNumber2(phoneNumber) && phoneVaildator.validPhoneNumber(phoneNumber)) {
                    Scanner filescanner = new Scanner(new File("phoneBook.txt"));
                    String currentLine = "";
                    String input = "";
                    boolean recordFound = false;

                    while (filescanner.hasNextLine()) {
                        currentLine = filescanner.nextLine();
                        int index = currentLine.indexOf(":");
                        if (currentLine.substring(0, index).equals(name) &&
                                currentLine.substring(index + 1).trim().equals(phoneNumber)) {
                            recordFound = true;
                            continue;
                        }
                        input += currentLine + '\n';
                    }

                    if (recordFound) {
                        System.out.println("Record deleted.");
                        // Updated file without deleted record
                        try (FileOutputStream fileOut = new FileOutputStream("phoneBook.txt", false)) {
                            fileOut.write(input.getBytes());
                        }
                    } else {
                        throw new IllegalArgumentException("Record not found.");
                    }
                    filescanner.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
