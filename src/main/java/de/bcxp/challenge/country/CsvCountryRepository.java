package de.bcxp.challenge.country;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.*;

import de.bcxp.challenge.fileHandling.CsvFileHandler;

public class CsvCountryRepository implements CountryRepository {

    private List<Country> countryEntries;

    private final CsvFileHandler fileHandler;

    public CsvCountryRepository(CsvFileHandler fileHandler){
        //this.filePath = filePath;
        this.countryEntries = new ArrayList<>();
        this.fileHandler = fileHandler;

            List<CSVRecord> records = fileHandler.getFileContents();
            for(CSVRecord record : records){
                if(!record.isConsistent()){
                    System.err.println("A CSV record is inconsistent");
                    continue;
                }
                countryEntries.add(new Country(
                                               record.get(CountryColumns.Name),
                                               record.get(CountryColumns.Capital),
                                               record.get(CountryColumns.Accession),
                                               convertPopulationToLong(record.get(CountryColumns.Population)),
                                               Long.parseLong(record.get(CountryColumns.Area)),
                                               Long.parseLong(record.get(CountryColumns.GDP)),
                                               convertToDouble(record.get(CountryColumns.HDI)),
                                               Long.parseLong(record.get(CountryColumns.MEPs))));
            }
    }

    private double convertToDouble(String s){
        s.replace(',', '.');
        return Double.parseDouble(s);
    }

    private long convertPopulationToLong(String s){
        s = s.replaceAll("\\.", "");
        int index = s.indexOf(",");
        if(index != -1){
            s = s.substring(0, index);
        }
        return Long.parseLong(s);
    }

    public Country getCountryByName(String name){
        for(Country country : countryEntries){
            if(country.getName().equals(name)){
                return country;
            }
        }
        return null;
    }

    public List<Country> getCountryEntries(){
        return countryEntries;
    }
}
