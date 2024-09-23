package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

public class Finish extends Command{
    @Override
    public void execute() {
        getConsoleUI().finish();
    }

    public Finish(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }
}
