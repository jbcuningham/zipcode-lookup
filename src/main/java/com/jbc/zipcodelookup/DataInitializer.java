package com.jbc.zipcodelookup;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
@EnableRedisDocumentRepositories
public class DataInitializer {
    private final ZipCodeRepo repository;

    public DataInitializer(ZipCodeRepo repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void loadData() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try {
            File file = new File("zip_code_database.csv");

            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                String[] dataBlocks = data.split(",");
                String zipCode = cleanString(dataBlocks[0]);
                String primaryCity = cleanString(dataBlocks[3]);
                List<String> altCities = new ArrayList<>();
                String abbreviatedState =
                        cleanString(dataBlocks[6].trim());
                String county = cleanString(dataBlocks[7]);

                Arrays.stream(dataBlocks[4].split(",")).forEach(s -> altCities.add(cleanString(s)));

                ZipCode toSave = new ZipCode(zipCode, primaryCity, altCities, abbreviatedState, county);
                repository.save(toSave);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String cleanString(String string) {
        return string.trim().replace("\"", "");
    }
}
