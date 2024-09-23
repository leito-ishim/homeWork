package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

public class SortByAge extends Command {
    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }

    public SortByAge(ConsoleUI consoleUI) {
        super("Сортировать по возрасту", consoleUI);
    }

}
