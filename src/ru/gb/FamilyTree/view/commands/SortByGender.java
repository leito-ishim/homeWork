package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

public class SortByGender extends Command {
    public SortByGender(ConsoleUI consoleUI) {
        super("Сортировать по полу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByGender();
    }
}
