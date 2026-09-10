package de.bcxp.challenge.fileHandling;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.*;

public class CsvFileHandler implements FileHandler<CSVRecord> {

    private List<CSVRecord> records;

    public CsvFileHandler(String filePath, char delimiter, Class<? extends Enum<?>> headerEnum){
        this.records = new ArrayList<>();

        try{
            //Path csvPath = Paths.get(filePath);
            //CSVParser parser = CSVParser.parse(csvPath, null, CSVFormat.Builder.create().setDelimiter(delimiter).setHeader(headerEnum).setSkipHeaderRecord(true).get());
            InputStream input = CsvFileHandler.class.getResourceAsStream(filePath);
            if(input == null)
                System.out.println("input is null");
            CSVParser parser = CSVParser.parse(input, null, CSVFormat.Builder.create().setDelimiter(delimiter).setHeader(headerEnum).setSkipHeaderRecord(true).get());
            records = parser.getRecords();
            /*for(CSVRecord record : records){
                if(!record.isConsistent()){
                    System.err.println("A CSV record is inconsistent");
                    continue;
                }
            }*/
            parser.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<CSVRecord> getFileContents(){
        return records;
    }
}
