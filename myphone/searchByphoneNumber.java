import java.io.File;
import java.util.Scanner;

public class searchByphoneNumber {

    public static void searchByPhoneNumber(String phoneNumber){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone number to search: ");
        phoneNumber = scanner.nextLine();
        phoneNumber = phoneNumber.replaceAll("\\s+", "");

        if (phoneNumber=="") {
            System.out.println("Null input");
        } else {
            try {
                // Check if the phone number is valid
                if(phoneVaildator.validPhoneNumber2(phoneNumber)&&(phoneVaildator.validPhoneNumber(phoneNumber))){
                    File file = new File("phoneBook.txt");
                    Scanner fileScanner = new Scanner(file);
                    boolean phoneNumberFound = false;

                    while (fileScanner.hasNextLine()) {
                        String currentLine = fileScanner.nextLine();

                        // Check if the phone number is found in PhoneBook.txt
                        if (currentLine.substring(currentLine.indexOf(":") + 2).trim().equals(phoneNumber)) {
                            String name = currentLine.substring(0, currentLine.indexOf(":"));
                            System.out.println("Phone Number: " + phoneNumber);
                            phoneNumberFound = true;
                            System.out.println("Name: " + name);
                        }
                    }
                    fileScanner.close();

                    if (!phoneNumberFound) {
                        throw new Exception("User not found");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}