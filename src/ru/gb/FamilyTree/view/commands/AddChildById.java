package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class AddChildById extends Command {
    private Integer id;
    public AddChildById(ConsoleUI consoleUI, Integer id) {
        super("Добавить ребенка", consoleUI);
        this.id = id;
    }


    @Override
    public void execute() throws IOException {
        getConsoleUI().addChildById(id);
    }
}
