package com.company;

public class Address {
    public String Street;

    public Address(String street, String city) {
        Street = street;
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }

    public String City;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!getStreet().equals(address.getStreet())) return false;
        return getCity().equals(address.getCity());
    }

}
