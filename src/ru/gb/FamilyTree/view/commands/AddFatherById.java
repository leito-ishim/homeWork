package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class AddFatherById extends Command {
    private Integer id;

    public AddFatherById(ConsoleUI consoleUI, Integer id) {
        super("Добавить отца по id", consoleUI);
        this.id = id;
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().addFatherById(id);
    }
}
