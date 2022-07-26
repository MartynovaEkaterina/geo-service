package ru.netology.entity;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Location other = (Location) obj;
        if (
                (city == other.city || (city != null && city.equals(other.city)))
                        && (country == other.country || (country != null && country.equals(other.country)))
                        && (street == other.street || (street != null && street.equals(other.street)))
                        && builing == other.builing
        ) {
            return true;
        } else {
            return false;
        }
    }
}
