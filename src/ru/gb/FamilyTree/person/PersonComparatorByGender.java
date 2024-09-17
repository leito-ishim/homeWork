package ru.gb.FamilyTree.person;

import java.util.Comparator;

public class PersonComparatorByGender implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
