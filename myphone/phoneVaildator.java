import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.Scanner;

public class phoneVaildator {

        public static boolean phoneNumberExists(String phoneNumber) {
            String filePath = "phoneBook.txt";
            File file = new File(filePath);
    
            try (Scanner filescanner = new Scanner(file)) {
                while (filescanner.hasNextLine()) {
                    String line = filescanner.nextLine();
                    int index = line.indexOf(":");
                    if (index != -1 && line.substring(index + 1).trim().equals(phoneNumber)) {
                        throw new IllegalArgumentException("Phone number already exists");
                    }
                }
                filescanner.close();
            } catch (IOException e) {
                e.printStackTrace(); 
            }
    
            return false;
        }
        private static final String PHONE_NUMBER_PATTERN = "^\\d{10}$";
    
        public static boolean validPhoneNumber(String phoneNumber) throws IllegalArgumentException {
            Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.matches()) {
                return true;
            } else {
                throw new IllegalArgumentException("Phone number should be 10 digits long.");
            }
        }

        public static boolean validPhoneNumber2(String phoneNumber) throws IllegalArgumentException {
            if(phoneNumber.matches("\\d+")){
                return true;
            }else{
                throw new IllegalArgumentException("Phone number cannot contain letters.");

            }
    }
}

