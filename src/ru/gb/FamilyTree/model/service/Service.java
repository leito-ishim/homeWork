package ru.gb.FamilyTree.model.service;

import ru.gb.FamilyTree.model.bulder.PersonBuilder;
import ru.gb.FamilyTree.model.family_tree.FamilyTree;
import ru.gb.FamilyTree.model.person.Gender;
import ru.gb.FamilyTree.model.person.Person;
import ru.gb.FamilyTree.model.writer.FileHandler;

import java.io.IOException;
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

    public boolean addSpouses(long personId1, long personId2) {
        familyTree.setAddSpouses(personId1, personId2);
        return true;
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
        return familyTree.toString();
    }

    public Person getPersonById(int id) {
        return (Person) familyTree.getById(id);
    }

    public boolean saveFamilyTreeToFile() throws IOException {
        FileHandler fh = new FileHandler();
        fh.save(familyTree);
        return true;
    }

    public boolean loadFamilyTreeFromFile() throws IOException {
        FileHandler fh = new FileHandler();
        familyTree = (FamilyTree) fh.load();
        return true;
    }

}
