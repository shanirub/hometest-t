package com.company;

public class Person {
    public Name getFullName() {
        return FullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!getFullName().equals(person.getFullName())) return false;
        return getAddress().equals(person.getAddress());
    }


    public com.company.Address getAddress() {
        return Address;
    }

    public Person(Name fullName, com.company.Address address) {
        FullName = fullName;
        Address = address;
    }

    public Name FullName;
    public Address Address;

}
