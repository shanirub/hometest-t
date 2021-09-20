package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

public class Main {
    public static Person[] people;

    public static boolean areRelated(Person personA, Person personB) {
        return (personA.getAddress().equals(personB.getAddress())) || (personA.getFullName().equals(personB.getFullName()));
    }

    // init method to load people and start the minimal relation check
    public static void Init(Person[] people) {
        System.out.println("min relation level for index 0 and index 1" + FindMinRelationLevel(people[0], people[1]));
    }

    // overloading to create a recursion
    private static int FindMinRelationLevel(Person personA, Person personB, int n, HashSet<Person> alreadyVisitedPersons) {
        // if related return n
        if (areRelated(personA, personB))
            return n;

        // if not related create a set of first related to personA
        HashSet<Person> firstRelated = new HashSet<>();
        for (Person p : people) {
            if (areRelated(p, personA))
                firstRelated.add(p);
        }

        // if first related set includes previous persons we should eliminate them - no endless loop
        firstRelated.removeAll(alreadyVisitedPersons);

        // for each person in the first related to personA we are calling the recursive function again
        // fr is added to alreadyVisitedPersons
        // n + 1 <-- counting levels

        // set for saving returned levels
        HashSet<Integer> min = new HashSet<>();

        for (Person fr: firstRelated) {
            alreadyVisitedPersons.add(personA);
            int temp = FindMinRelationLevel(fr, personB, n + 1, alreadyVisitedPersons);
            min.add(temp);
        }

        // if there are no persons left to check
        if (min.isEmpty())
            return -1;

        // if there are only -1 in set, we return -1, otherwise we return the minimum
        return min.stream().mapToInt(Integer::intValue).filter(x -> x > -1).min().orElse(-1);
    }

    // starter function for recursion
    public static int FindMinRelationLevel(Person personA, Person personB) {
        HashSet<Person> a = new HashSet<>();
        a.add(personA);
        return FindMinRelationLevel(personA, personB, 1, a);
    }


    public static void main(String[] args) {

        // generating people for testing
        Name n1 = new Name("Shani", "Rubovitch");
        Name n2 = new Name("Dana", "Kama");
        Name n3 = new Name("Mario", "Bros");
        Name n4 = new Name("Frau", "Rubovitch");

        Address a1 = new Address("Hazaz", "Tel Aviv");
        Address a2 = new Address("Dreilinderstr", "Leipzig");
        Address a3 = new Address("Richterstr", "Leipzig");
        Address a4 = new Address("Somewhere", "Rainbow");


        Person p11 = new Person(n1, a1);
        Person p22 = new Person(n2, a2);
        Person p33 = new Person(n3, a3);

        Person p12 = new Person(n1, a2);
        Person p13 = new Person(n1, a3);
        Person p23 = new Person(n2, a3);

        Person p34 = new Person(n3, a4);
        Person p44 = new Person(n4, a4);

        people = new Person[]{p11, p11, p33, p12, p13, p23, p34, p44};
        Init(people);

    }
}
