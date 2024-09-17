package ru.gb.FamilyTree.service;

import ru.gb.FamilyTree.family_tree.FamilyTree;
import ru.gb.FamilyTree.person.Gender;
import ru.gb.FamilyTree.person.Person;

import java.time.LocalDate;

public class Service {
    private PersonBuilder personBuilder;
    private FamilyTree familyTree;

    public Service() {
        personBuilder = new PersonBuilder();
        familyTree = new FamilyTree();
    }

    public Service(FamilyTree familyTree) {
        personBuilder = new PersonBuilder();
        this.familyTree = familyTree;
    }

    public void addPerson(String surname, String name, Gender gender, LocalDate dateOfBirth) {
        Person person = personBuilder.build(surname, name, gender, dateOfBirth);
        familyTree.addPerson(person);
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void sortPersonsByName() {
        familyTree.sortByName();
    }

    public void sortPersonsByGender() {
        familyTree.sortByGender();
    }

    public void sortPersonsByAge() {
        familyTree.sortByAge();
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(familyTree.toString());
        return stringBuilder.toString();
    }

}
