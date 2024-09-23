package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public abstract class Command {
    private final String description;
    private final ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public abstract void execute() throws IOException;

    public String getDescription() {
        return description;
    }
    ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
