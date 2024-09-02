import java.io.IOException;
import java.util.Scanner;


public class Nokia {
    public static void main(String[] args) throws IOException {

        // test.generateRecords("phoneBook.txt",1000);
        boolean systemStatus = true;
        String msg = "Allowed input is a number btn 1 and 5";
        
        while (systemStatus) {
            System.out.println("Nokia PhoneBook Application");
            System.out.println("Please select an option:");
            System.out.println("1. Add new subscriber to phone book");
            System.out.println("2. Search for subscriber by name");
            System.out.println("3. Search for subscriber by phone number");
            System.out.println("4. Delete a subscriber");
            System.out.println("5. Exit");

            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("What do you want to do: ");
                int option = scanner.nextInt();                
                switch (option) {
                    case 1:
                        AddRecord.addRecord(null, null);
                        break;
                    case 2:
                        SearchByName.searchByName(null);
                        break;
                    case 3:
                        searchByphoneNumber.searchByPhoneNumber(null);
                        break;
                    case 4:
                        DeleteRecord.deleteRecord(null, null);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        systemStatus = false;
                        System.exit(0);
                        break;
                    default:
                        System.out.println(msg);
                        break;
                }
             } catch (Exception e) {
                System.out.println(msg);
            }
        }
    }
}
