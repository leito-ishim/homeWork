package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class AddMotherById extends Command {
    private Integer id;
    public AddMotherById(ConsoleUI consoleUI, Integer id) {
        super("Добавить мать", consoleUI);
        this.id = id;
    }


    @Override
    public void execute() throws IOException {
        getConsoleUI().addMotherById(id);
    }
}
