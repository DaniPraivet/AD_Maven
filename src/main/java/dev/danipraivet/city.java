package dev.danipraivet;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="city")
public class city {
    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private int Population;
    private List<city> cities = new ArrayList();

    public int getID() {
        return ID;
    }

    public List<city> getCities() {
        return cities;
    }

    public int getPopulation() {
        return Population;
    }

    public String getDistrict() {
        return District;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getName() {
        return Name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public void setCities(List<city> cities) {
        this.cities = cities;
    }
}
