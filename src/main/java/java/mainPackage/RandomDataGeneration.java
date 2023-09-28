package mainPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class RandomDataGeneration {
    public static void main(String[] args) {
        // Generate random values for email, name, and password
        String randomEmail = generateRandomEmail();
        String randomName = generateRandomName();
        String randomPassword = generateRandomPassword();
        String confirmPassword = generateRandomPassword();

        // Create a Properties object to store the values
        Properties prop = new Properties();
        prop.setProperty("email", randomEmail);
        prop.setProperty("name", randomName);
        prop.setProperty("password", randomPassword);
        prop.setProperty("password", confirmPassword);
        // Write the properties to a file
        try (FileOutputStream fos = new FileOutputStream("./config.properties")) {
            prop.store(fos, null);
            System.out.println("Random values written to config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomEmail() {
        // Generate a random email address
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com"};
        String randomDomain = domains[new Random().nextInt(domains.length)];
        return "user" + new Random().nextInt(10000) + "@" + randomDomain;
    }

    public static String generateRandomName() {
        // Generate a random name
        return "User" + new Random().nextInt(10000);
    }

    public static String generateRandomPassword() {
        // Generate a random password (customize as needed)
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()_-+=<>?";
        String allChars = uppercase + lowercase + digits + specialChars;
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) { // Adjust the length of the password as needed
            int randomIndex = new Random().nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
