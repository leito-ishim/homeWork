package ru.gb.FamilyTree.person;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person {
    private String name, surname, patronymicName; // Имя, Фамилия, Отчество (задается, когда устанавливается отец)
    private LocalDate dateOfBirth, dateOfDeath; // Даты рождения и смерти
    private Person father, mother;  // Отец и мать
    private ArrayList<Person> children = new ArrayList<>(); //Массив с детьми
    private Gender gender; // Пол
    private int age; // Возраст


    public Person(String surname, String name, LocalDate dateOfBirth, Gender gender) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender.toString();
    }

    @Override
    public String toString() {
        return name + " " + surname + ", родился: " + dateOfBirth + ", " + gender;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public int getAge() {
        if (dateOfDeath != null) {
            this.age = dateOfDeath.getYear() - dateOfBirth.getYear();
        } else {
            this.age = LocalDate.now().getYear() - dateOfBirth.getYear();
        }
        return this.age;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        if (father.getGender().equals("Male")) {
            this.father = father;
        } else {
            System.out.println("Отец должен быть мужчиной");
        }

    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        if (mother.getGender().equals("Female")) {
            this.mother = mother;
        } else {
            System.out.println("Мать должна быть женщиной");
        }

    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void addChild(Person child) {
        if (this.age - child.getAge() >= 16) {
            children.add(child);
        } else {
            System.out.println(child.getName() + " родился в " + child.getDateOfBirth().getYear() + "году: Слишком молод чтобы быть сыном");
        }

    }

    public String getChildren() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дети ").append(this.name).append(" ").append(this.surname).append(":\n");
        for (Person child : children) {
            sb.append("\t").append(child).append("\n");
        }
        return sb.toString();
    }
}
