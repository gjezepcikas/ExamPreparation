package lt.techin;

import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RandomDataGenerator {
    private static final Random random = new Random();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static String getRandomFirstName() {
        String[] firstNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles",
                "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth",
                "George", "Joshua", "Kevin", "Brian", "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan",
                "Jacob", "Gary", "Nicholas", "Eric", "Jonathan", "Stephen", "Larry", "Justin", "Scott", "Brandon"};
        return firstNames[random.nextInt(firstNames.length)];
    }

    public static String getRandomLastName() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
                "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin",
                "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson",
                "Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores"};
        return lastNames[random.nextInt(lastNames.length)];
    }

    public static String getRandomEmail(String firstName,String lastName) {
        String[] domains = {"example.com", "test.com", "mail.com", "email.com"};
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + domains[random.nextInt(domains.length)];
    }

    public static String getRandomPassword() {
        int length = 10 + random.nextInt(9); // Password length between 8 and 16
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }

    public static String getRandomBirthDate() {
        int year = 1950 + random.nextInt(51); // Random year between 1950 and 2000
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28); // To keep it simple, using 28 days
        LocalDate birthDate = LocalDate.of(year, month, day);
        return birthDate.format(dateFormatter);
    }
}
