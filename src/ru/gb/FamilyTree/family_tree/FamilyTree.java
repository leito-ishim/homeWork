package ru.gb.FamilyTree.family_tree;

import ru.gb.FamilyTree.person.Person;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private String nameTree;
    private final List<Person> familyMembers;

    public FamilyTree(String nameTree) {
        familyMembers = new ArrayList<>();
        this.nameTree = nameTree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Гениалогическое древо семьи: ").append(nameTree).append("\n");
        sb.append("Количество членов семьи: ").append(familyMembers.size()).append("\n");
        return sb.toString();
    }

    public void addFamilyMember(Person person) {
        if (!familyMembers.contains(person)) {
            familyMembers.add(person);
            System.out.println("В гениалогическое древо добавлен: " + person);
        }
    }

    public String showAllFamilyMembers() {
        StringBuilder sb = new StringBuilder();
        for (Person person : familyMembers) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<Person> getFamilyMembers() {
        return familyMembers;
    }

    public String getNameTree() {
        return nameTree;
    }

    public Person getFamilyMember(String name) {
        for (Person person : familyMembers) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void setFatherForPerson(Person father, Person child) {
        if (father != child) {
            if (father.getGender().equals("Male")) {
                if (father.getAge() - child.getAge() >= 16) {
                    father.addChild(child);
                    child.setFather(father);
                    System.out.println("Добавлена связь: " + father + " отец -> " + child);
                    if (!familyMembers.contains(father)) {
                        familyMembers.add(father);
                    }
                    if (!familyMembers.contains(child)) {
                        familyMembers.add(child);
                    }
                } else {
                    System.out.println("Маленькая разница в возрасте. Не могут быть отцом и ребенком");
                }
            } else {
                System.out.println("Отец должен быть мужчиной");
            }

        }
    }
}
