package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class LoadFromFile extends Command {

    public LoadFromFile(ConsoleUI consoleUI) {
        super("Загрузить семейное древо из файла", consoleUI);
    }
    @Override
    public void execute() throws IOException {
        getConsoleUI().loadFromFile();
    }
}
