package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class SaveToFile extends Command {

    public SaveToFile(ConsoleUI consoleUI) {
        super("Сохранить семейное древо в файл", consoleUI);
    }
    @Override
    public void execute() throws IOException {
        getConsoleUI().saveInFile();
    }
}
