package com.company;

public class Name {
    public Name(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        if (!getFirstName().equals(name.getFirstName())) return false;
        return getLastName().equals(name.getLastName());
    }


    public String getLastName() {
        return LastName;
    }

    public String FirstName;
    public String LastName;

}
