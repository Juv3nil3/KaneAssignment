package main.validation;

import main.model.Person;

import java.util.regex.Pattern;

public class PersonValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static boolean isValid(Person person) {
        return hasValidEmail(person)&&hasAddress(person)&&livesInIndia(person);
    }

    private static boolean hasValidEmail(Person person) {

        String email = person.email();

        return email != null
                && !email.isBlank()
                && EMAIL_PATTERN.matcher(email).matches();
    }

    private static boolean hasAddress(Person person) {

        String address = person.address();

        return address != null
                && !address.isBlank();
    }

    private static boolean livesInIndia(Person person) {

        String address = person.address();

        return address != null
                && address.toLowerCase().contains("india");
    }
}
