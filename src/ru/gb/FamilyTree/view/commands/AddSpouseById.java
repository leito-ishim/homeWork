package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class AddSpouseById extends Command{
    private Integer id;
    public AddSpouseById(ConsoleUI consoleUI, Integer id) {
        super("Добавить супруга(у)", consoleUI);
        this.id = id;
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().addSpouseById(id);
    }
}
