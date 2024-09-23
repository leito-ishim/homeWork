package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class ShowSortMenu extends Command {

    public ShowSortMenu(ConsoleUI consoleUI) {
        super("Меню сортировки", consoleUI);
    }
    @Override
    public void execute() throws IOException {
        getConsoleUI().showSortMenu();
    }
}
