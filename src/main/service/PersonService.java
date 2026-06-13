package main.service;

import main.model.Person;
import main.parser.PersonParser;
import main.validation.PersonValidator;
import main.writer.CsvWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class PersonService {

    public static void processPersons() throws IOException {

        Path inputPath = Path.of("input.txt");
        Path outputPath = Path.of("output.csv");

        List<Person> people = PersonParser.parseFile(inputPath);
        System.out.println("Parsed persons: " + people.size());
        people.forEach(person -> System.out.println(person.toString()));

        List<Person> validPeople =
                people.stream()
                        .filter(PersonValidator::isValid)
                        .toList();

        CsvWriter csvWriter = new CsvWriter();
        csvWriter.write(outputPath, validPeople);
    }
}
