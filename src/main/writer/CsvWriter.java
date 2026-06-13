package main.writer;

import main.model.Person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvWriter {

    public void write(Path outputFile, List<Person> persons) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {

            // Header
            writer.write("Name,Category");
            writer.newLine();

            for (Person person : persons) {

                writer.write(person.name() + "," + person.category());

                writer.newLine();
            }
        }
    }
}
