package de.bcxp.challenge.country;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bcxp.challenge.fileHandling.CsvFileHandler;

public class CsvCountryRepository implements CountryRepository {

    private List<Country> countryEntries;

    static final Logger logger = LoggerFactory.getLogger(CsvCountryRepository.class);

    public CsvCountryRepository(CsvFileHandler fileHandler){
        this.countryEntries = new ArrayList<>();

            List<CSVRecord> records = fileHandler.getFileContents();
            for(CSVRecord record : records){
                try{
                    countryEntries.add(new Country(
                                                record.get(CountryColumns.Name),
                                                record.get(CountryColumns.Capital),
                                                record.get(CountryColumns.Accession),
                                                convertPopulationToLong(record.get(CountryColumns.Population)),
                                                Long.parseLong(record.get(CountryColumns.Area)),
                                                Long.parseLong(record.get(CountryColumns.GDP)),
                                                convertToDouble(record.get(CountryColumns.HDI)),
                                                Long.parseLong(record.get(CountryColumns.MEPs))));
                }catch(NumberFormatException e){
                    logger.error("Failed to parse the CSV data to a Country object", e);
                }
            }
    }

    /**
     *Converts a String of a number using ',' as the decimal seperator to a double
     *@param s the String to be converted
     *@return the double value
     **/
    private double convertToDouble(String s){
        s.replace(',', '.');
        return Double.parseDouble(s);
    }

    /**
     *Converts a String representing the population to a long by removing all occurences of '.' as a number divider and removing the fractional part of the number
     *@param s the String to be converted
     *@return the long value
     **/
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
