package de.bcxp.challenge.fileHandling;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvFileHandler implements FileHandler<CSVRecord> {

    private List<CSVRecord> records;
    static final Logger logger = LoggerFactory.getLogger(CsvFileHandler.class);

    public CsvFileHandler(String filePath, char delimiter, Class<? extends Enum<?>> headerEnum){
        this.records = new ArrayList<>();

        try{
            InputStream input = CsvFileHandler.class.getResourceAsStream(filePath);
            if(input == null)
                System.out.println("input is null");
            CSVParser parser = CSVParser.parse(input, null, CSVFormat.Builder.create().setDelimiter(delimiter).setHeader(headerEnum).setSkipHeaderRecord(true).get());
            records = parser.getRecords();
            parser.close();
        }catch(Exception e){
            logger.error("Failed to open input file and parse the CSV data", e);
        }
    }

    public List<CSVRecord> getFileContents(){
        return records;
    }
}
