package ru.gb.FamilyTree;

import ru.gb.FamilyTree.model.family_tree.FamilyTree;
import ru.gb.FamilyTree.model.person.Gender;
import ru.gb.FamilyTree.model.person.Person;
import ru.gb.FamilyTree.model.service.Service;
import ru.gb.FamilyTree.view.ConsoleUI;
import ru.gb.FamilyTree.view.View;

import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();
        //        FamilyTree ft = new FamilyTree();
//        FamilyTree ft = createFamilyTree();
//        Service service = new Service(ft);
//
//
//
//        System.out.println(service.getFamilyTreeInfo());
//        service.sortPersonsByAge();
//        System.out.println(service.getFamilyTreeInfo());
//        service.sortPersonsByName();
//        System.out.println(service.getFamilyTreeInfo());
//        service.sortPersonsByGender();
//        System.out.println(service.getFamilyTreeInfo());




//        FileHandler fh = new FileHandler("test");
//        fh.save(ft);

//        FamilyTree ftRestored = (FamilyTree) fh.load();
//        System.out.println(ftRestored);



    }

    public static FamilyTree createFamilyTree() {
        FamilyTree ft = new FamilyTree();
        Person ivan = new Person("Иванов", "Иван", Gender.Male, LocalDate.parse("1989-10-31"));
        Person petr = new Person("Иванов", "Петр", Gender.Male, LocalDate.parse("1962-05-15"));
        Person anna = new Person("Смирнова", "Анна", Gender.Female, LocalDate.parse("1964-06-28"));
        Person ekaterina = new Person("Иванова", "Екатерина", Gender.Female, LocalDate.parse("1991-11-02"), petr, anna);
        ft.addPerson(petr);
        ft.addPerson(anna);
        ft.setAddSpouses(petr, anna);

        ft.addPerson(ivan);
        ivan.setFather(petr);
        ivan.setMother(anna);

        petr.addChild(ivan);
        anna.addChild(ivan);

        ft.addPerson(ekaterina);

        Person sveta = new Person("Волкова", "Светлана", Gender.Female, LocalDate.parse("1990-02-21"));

        ft.addPerson(sveta);
        ft.setAddSpouses(ivan, sveta);

        Person gleb = new Person("Иванов", "Глеб", Gender.Male, LocalDate.parse("2017-11-01"), ivan, sveta);

        ft.addPerson(gleb);
        return ft;
    };

}
