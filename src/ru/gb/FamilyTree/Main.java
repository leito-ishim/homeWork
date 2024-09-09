package ru.gb.FamilyTree;

import ru.gb.FamilyTree.family_tree.FamilyTree;
import ru.gb.FamilyTree.person.Gender;
import ru.gb.FamilyTree.person.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree("Ивановы");

        Person person1 = new Person("Иванов", "Иван", LocalDate.parse("1989-10-31"), Gender.Male);
        Person person2 = new Person("Иванов", "Петр", LocalDate.parse("1962-05-15"), Gender.Male);
        Person person3 = new Person("Смирнова", "Анна", LocalDate.parse("1964-06-28"), Gender.Female);
        Person person4 = new Person("Иванова", "Екатерина", LocalDate.parse("1991-11-02"), Gender.Female);

        System.out.println(person1.getAge());
        System.out.println(person2.getAge());
        ft.setFatherForPerson(person2, person1);
        System.out.println(person1.getFather());
        System.out.println(person1.getMother());

        System.out.println(person2.getChildren());

//        System.out.println(person1);
//        System.out.println(person2);
//        System.out.println(person3);
//        System.out.println(person4);
//        System.out.println(person1.getGender());

        ft.addFamilyMember(person1);
        ft.addFamilyMember(person2);
        ft.addFamilyMember(person3);
        ft.addFamilyMember(person4);

//        System.out.println(ft);
//        System.out.println(ft.showAllFamilyMembers());
//        System.out.println(ft.getFamilyMembers());
//        System.out.println(ft.getFamilyMember("Иван"));
    }




}
