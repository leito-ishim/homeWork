package ru.gb.FamilyTree.view;

import ru.gb.FamilyTree.presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException {
        System.out.println("Добро пожаловать!");
        while (work) {
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }

    }

    public void addPerson() {
        System.out.println("Укажите имя:");
        String name = scanner.nextLine();
        System.out.println("Укажите фамилию:");
        String surname = scanner.nextLine();
        // можно сделать отдельно меню для гендера
        System.out.println("Укажите пол:\n1 - Мужской\n2 - Женский");
        String genderStr = scanner.nextLine();
        int genderInt = Integer.parseInt(genderStr);
        System.out.println("Укажите год рождения:");
        String yearStr = scanner.nextLine();
        System.out.println("Укажите месяц рождения (номер):");
        String monthStr = scanner.nextLine();
        System.out.println("Укажите день рождения (номер):");
        String dayStr = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(yearStr+"-"+monthStr+"-"+dayStr);
        presenter.addPerson(surname, name, genderInt, dateOfBirth);
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByGender() {
        presenter.sortByGender();
    }

    public void saveInFile() throws IOException {
        presenter.saveToFile();
    }

    public void loadFromFile() throws IOException {
        presenter.loadFromFile();
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("Работа завершена");
    }

    public void setConnectParentAndChild() {
        System.out.println("Введите Id родителя:");
        String idParentStr = scanner.nextLine();
        int idParent = Integer.parseInt(idParentStr);
        System.out.println("Введите Id ребенка:");
        String idChildStr = scanner.nextLine();
        int idChild = Integer.parseInt(idChildStr);
        presenter.setConnectParentAndChild(idParent, idChild);
    }

    public void addSpouses() {
        System.out.println("Введите Id жениха:");
        String idParent1Str = scanner.nextLine();
        int idParent1 = Integer.parseInt(idParent1Str);
        System.out.println("Введите Id невесты:");
        String idParent2Str = scanner.nextLine();
        int idParent2 = Integer.parseInt(idParent2Str);
        presenter.addSpouses(idParent1, idParent2);
    }

    public void showMainMenu() throws IOException {
        this.menu = new MainMenu(this);
    }

    public void showSortMenu() {
        this.menu = new SortMenu(this);
    }

    public void addConnectById() {
        System.out.println("Введите Id человека, которому хотите установить связи:");
        String idStr = scanner.nextLine();
        int id = Integer.parseInt(idStr);
        presenter.getPersonInfo(id);
        this.menu = new ConnectingByIDMenu(this, id);
    }

    public void addFatherById(int id) {
        System.out.println("Введите Id отца:");
        String idParentStr = scanner.nextLine();
        int idParent = Integer.parseInt(idParentStr);
        presenter.setConnectParentAndChild(idParent, id);
    }

    public void addMotherById(int id) {
        System.out.println("Введите Id матери:");
        String idParentStr = scanner.nextLine();
        int idParent = Integer.parseInt(idParentStr);
        presenter.setConnectParentAndChild(idParent, id);
    }

    public void addChildById(int id) {
        System.out.println("Введите Id ребенка:");
        String idChildStr = scanner.nextLine();
        int idChild = Integer.parseInt(idChildStr);
        presenter.setConnectParentAndChild(id, idChild);
    }

    public void addSpouseById(int id) {
        System.out.println("Введите Id супруга(и):");
        String idSpouseStr = scanner.nextLine();
        int idSpouse = Integer.parseInt(idSpouseStr);
        presenter.addSpouses(id, idSpouse);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
