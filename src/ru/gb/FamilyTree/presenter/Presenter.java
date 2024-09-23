package ru.gb.FamilyTree.presenter;

import ru.gb.FamilyTree.model.person.Gender;
import ru.gb.FamilyTree.model.person.Person;
import ru.gb.FamilyTree.model.service.Service;
import ru.gb.FamilyTree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }


    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }

    public void addPerson(String surname, String name, int genderInt, LocalDate dateOfBirth) {
        Gender gender = null;
        if (genderInt == 1) {
            gender = Gender.Male;
        } else if (genderInt == 2) {
            gender = Gender.Female;
        }
        service.addPerson(surname, name, gender, dateOfBirth);
        getFamilyTreeInfo();
    }


    public void sortByAge() {
        service.sortPersonsByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortPersonsByName();
        getFamilyTreeInfo();
    }

    public void sortByGender() {
        service.sortPersonsByGender();
        getFamilyTreeInfo();
    }

    public void saveToFile() throws IOException {
        if (service.saveFamilyTreeToFile()) {
            view.printAnswer("Семейное древо успешно сохранено.");
        } else {
            view.printAnswer("Не сохранено.");
        }
    }

    public void loadFromFile() throws IOException {
        if (service.loadFamilyTreeFromFile()) {
            getFamilyTreeInfo();
        } else {
            view.printAnswer("Файл не загружен");
        }
    }

    public void setConnectParentAndChild(int idParent, int idChild) {
        Person parent = service.getPersonById(idParent);
        Person child = service.getPersonById(idChild);
        if (parent.addChild(child) && child.addParent(parent)) {
            view.printAnswer("Связь создана:\nРодитель: " + parent.getName() + "\nРебенок: " + child.getName());
        } else {
            view.printAnswer("Связь не создана");
        }
//        service.getPersonById(idParent).addChild(service.getPersonById(idChild));
//        service.getPersonById(idChild).addParent(service.getPersonById(idParent));

    }

    public void addSpouses(int idParent1, int idParent2) {
        if (service.addSpouses(idParent1, idParent2)) {
            view.printAnswer("Свадьба состоялась:\nМуж: " + service.getPersonById(idParent1).getName() + "\nЖена: " + service.getPersonById(idParent2).getName());
        }
    }

    public void getPersonInfo(int id) {
        Person person = service.getPersonById(id);
        view.printAnswer(person.toString());
    }
}
