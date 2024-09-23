package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

public class SortByName extends Command {
    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }

    public SortByName(ConsoleUI consoleUI) {
        super("Сортировать по имени", consoleUI);
    }

}
