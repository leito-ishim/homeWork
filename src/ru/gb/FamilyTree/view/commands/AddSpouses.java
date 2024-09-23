package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class AddSpouses extends Command {
    @Override
    public void execute() throws IOException {
        getConsoleUI().addSpouses();
    }

    public AddSpouses(ConsoleUI consoleUI) {
        super("Сыграть свадьбу", consoleUI);
    }
}
