import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddRecord {

    public static void addRecord(String name, String phoneNumber) {

        String filePath = "phoneBook.txt";
        try {
            File file = new File(filePath);

            try (FileWriter writer = new FileWriter(file, true)) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Name: ");
                name = scanner.nextLine().toLowerCase().strip();
                System.out.print("Phone: ");
                phoneNumber = scanner.nextLine().strip();
                phoneNumber = phoneNumber.replaceAll("[\\s+]", "");

                if (name == "" || phoneNumber=="") {
                    System.out.println("Null inputs");
                } else {
                    boolean dataReady = false;

                    // In this try block, I am running a set of checks to ensure that the data is valid
                    try {
                        // check if a subscriber has been assigned the number before
                        if (!phoneVaildator.phoneNumberExists(phoneNumber)) {

                            // Check if phone number contains letters
                            if (phoneVaildator.validPhoneNumber2(phoneNumber)) {

                                // Check if phone number is valid
                                if (phoneVaildator.validPhoneNumber(phoneNumber)) {
                                    dataReady = true;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // If all checks are passed, write the data to the file
                    try {
                        if (dataReady) {
                            writer.write(name + ": " + phoneNumber);
                            writer.write(System.lineSeparator());
                            System.out.println("Record added successfully.");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something unexpected happened.");
        }
    }
}
