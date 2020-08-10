package sample;

import fatjar.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class City implements DB.JdbcEntity {

    private long id;
    private String name;
    private String countrycode;
    private String district;
    private long population;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String getTableName() {
        return "city";
    }

    @Override
    public void read(ResultSet resultSet) throws SQLException {
        this.setId(resultSet.getLong("id"));
        this.setName(resultSet.getString("name"));
        this.setCountrycode(resultSet.getString("countrycode"));
        this.setDistrict(resultSet.getString("district"));
        this.setPopulation(resultSet.getLong("population"));
    }

}