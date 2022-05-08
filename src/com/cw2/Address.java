package com.cw2;

public class Address {
    private String country;
    private String city;
    private String street;
    private int house;
    private int flat;

    public Address(String country, String city, String street, int house, int flat) {
        setCountry(country);
        setCity(city);
        setStreet(street);
        setHouse(house);
        setFlat(flat);
    }

    public Address() {
        house = 0;
        flat = 0;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country == null || country.isEmpty()) {
            throw new RuntimeException("Country field cannot be empty");
        }
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null || city.isEmpty()) {
            throw new RuntimeException("City field cannot be empty");
        }
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(street == null || street.isEmpty()) {
            throw new RuntimeException("City field cannot be empty");
        }
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        if (house <= 0) {
            throw new RuntimeException("Incorrect value for house field");
        }
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        if (flat == 0 || flat == 1) {
            this.flat = flat;
        }
        else throw new RuntimeException("Incorrect value for flat field");
    }
}
