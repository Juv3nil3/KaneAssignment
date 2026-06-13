package main.parser;

import main.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonParser {

    public static List<Person> parseFile(Path path){

        List<Person> people = new ArrayList<Person>();
        try{
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if(line.isBlank()){
                    continue;
                }
                Person person = parseLine(line);
                people.add(person);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return people;
    }

    private static Person parseLine(String line){

        String[] parts = line.split(",");

        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid record");
        }

        String name = parts[0].trim();
        String ageString = parts[1].trim();

        Integer age = null;
        if (!ageString.isBlank()) {
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException ignored) {
            }
        }

        String email = parts[parts.length - 1].trim();

        // Address may contain commas.
        // Everything between age and email is treated as address.

        String addressString = parts[2].trim();
        String address = null;
        if (!addressString.isBlank()) {
              address = Arrays.stream(parts, 2, parts.length - 1)
                    .map(String::trim)
                    .collect(Collectors.joining(", "));
        }

        return new Person(
                name,
                age,
                address,
                email
        );

    }
}
