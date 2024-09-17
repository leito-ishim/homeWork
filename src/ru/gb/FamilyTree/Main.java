package ru.gb.FamilyTree;

import ru.gb.FamilyTree.family_tree.FamilyTree;
import ru.gb.FamilyTree.person.Gender;
import ru.gb.FamilyTree.person.Person;
import ru.gb.FamilyTree.writer.FileHandler;

import java.io.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

        Person gleb = new Person("Иванов", "Глеб", Gender.Male, LocalDate.parse("2017-11-01"), ivan,sveta);

        ft.addPerson(gleb);


        System.out.println(ft);

//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("familyTree.ser"));
//        objectOutputStream.writeObject(ft);
//        objectOutputStream.close();
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("familyTree.ser"));
//        FamilyTree ftRestored = (FamilyTree) objectInputStream.readObject();
//        objectInputStream.close();
//
//        System.out.println(ftRestored);
//
//        System.out.println(ftRestored.getByName("Иван"));
//        System.out.println(ftRestored.getById(3).getParents());

        FileHandler fh = new FileHandler("test");
//        fh.save(ft);

        FamilyTree ftRestored = (FamilyTree) fh.load();
        System.out.println(ftRestored);



    }

}
