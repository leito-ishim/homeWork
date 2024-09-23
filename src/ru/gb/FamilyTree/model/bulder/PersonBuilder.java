package ru.gb.FamilyTree.model.bulder;

import ru.gb.FamilyTree.model.person.Gender;
import ru.gb.FamilyTree.model.person.Person;

import java.time.LocalDate;

public class PersonBuilder {
    private int id;

    public Person build(String surname, String name, Gender gender, LocalDate dateOfBirth) {
        return new Person(surname, name, gender, dateOfBirth);
    }
}
