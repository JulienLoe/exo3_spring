package com.example.exo3spring.helper;

import com.example.exo3spring.models.ActeurDTO;
import com.example.exo3spring.models.Credits;
import com.example.exo3spring.models.Tutorial;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CSVHelperCredits {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id","cast", "crew", "id"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Credits> csvToCredits(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Credits> credits = new ArrayList<Credits>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Credits credit = new Credits(
                        csvRecord.get("crew"),
                        csvRecord.get("cast").split("\""),

                        Integer.parseInt(csvRecord.get("id"))




                );

                credits.add(credit);
            }

            return credits;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
