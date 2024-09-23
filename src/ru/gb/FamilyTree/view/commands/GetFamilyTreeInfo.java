package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

public class GetFamilyTreeInfo extends Command {
    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super("Показать семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTreeInfo();
    }
}
