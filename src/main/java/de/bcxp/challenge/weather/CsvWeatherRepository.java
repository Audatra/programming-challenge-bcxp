package de.bcxp.challenge.weather;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bcxp.challenge.fileHandling.CsvFileHandler;

public class CsvWeatherRepository implements WeatherRepository {

    private List<Weather> weatherEntries;

    final static Logger logger = LoggerFactory.getLogger(CsvWeatherRepository.class);

    public CsvWeatherRepository(CsvFileHandler fileHandler){
        this.weatherEntries = new ArrayList<>();

            List<CSVRecord> records = fileHandler.getFileContents();
            for(CSVRecord record : records){
                try{
                    weatherEntries.add(new Weather(
                                                Integer.parseInt(record.get(WeatherColumns.Day)),
                                                Integer.parseInt(record.get(WeatherColumns.MxT)),
                                                Integer.parseInt(record.get(WeatherColumns.MnT)),
                                                Double.parseDouble(record.get(WeatherColumns.AvT)),
                                                Double.parseDouble(record.get(WeatherColumns.AvDP)),
                                                Integer.parseInt(record.get(WeatherColumns.TPcpn)),
                                                Integer.parseInt(record.get(WeatherColumns.PDir)),
                                                Double.parseDouble(record.get(WeatherColumns.AvSp)),
                                                Integer.parseInt(record.get(WeatherColumns.Dir)),
                                                Integer.parseInt(record.get(WeatherColumns.MxS)),
                                                Double.parseDouble(record.get(WeatherColumns.SkyC)),
                                                Integer.parseInt(record.get(WeatherColumns.MxR)),
                                                Integer.parseInt(record.get(WeatherColumns.MnR)),
                                                Double.parseDouble(record.get(WeatherColumns.AvSLP))
                                                ));
                }catch(NumberFormatException e){
                    logger.error("Failed to parse the CSV data to a Weather object", e);
                }
            }
    }

    public Weather getWeatherByDay(int day){
        return weatherEntries.get(day-1);
    }

    public List<Weather> getWeatherEntries(){
        return weatherEntries;
    }
}
