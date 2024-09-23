package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.Console;
import java.io.IOException;

public class AddConnectById extends Command {
    @Override
    public void execute() throws IOException {
        getConsoleUI().addConnectById();
    }

    public AddConnectById(ConsoleUI consoleUI) {
        super("Добавить родственные связи конкретному человеку по ID", consoleUI);
    }
}
