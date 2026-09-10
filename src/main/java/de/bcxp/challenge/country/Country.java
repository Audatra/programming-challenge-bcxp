package de.bcxp.challenge.country;

public class Country{
    private String name, capital, accession;
    private long population, area, gdp, meps;
    private double hdi;

    public Country(String name, String capital, String accession, long population, long area, long gdp, double hdi, long meps){
        this.name = name;
        this.capital = capital;
        this.accession = accession;
        this.population = population;
        this.area = area;
        this.gdp = gdp;
        this.hdi = hdi;
        this.meps = meps;

    }

	public String getName() {
		return name;
	}
	public String getCaptial() {
		return capital;
	}
    public String getAccession() {
        return accession;
    }
	public long getPopulation() {
		return population;
	}
	public long getArea() {
		return area;
	}
    public long getGdp() {
        return gdp;
    }
    public double getHdi() {
        return hdi;
    }
    public long getMeps() {
        return meps;
    }
}
