package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class ShowMainMenu extends Command {
    public ShowMainMenu(ConsoleUI consoleUI) {
        super("Показать основное меню", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().showMainMenu();
    }
}
