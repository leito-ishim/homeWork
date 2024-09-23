package ru.gb.FamilyTree.view.commands;

import ru.gb.FamilyTree.view.ConsoleUI;

import java.io.IOException;

public class SetConnectParentAndChild extends Command {
    public SetConnectParentAndChild(ConsoleUI consoleUI) {
        super("Установить связь родитель-ребенок", consoleUI);
    }


    @Override
    public void execute() throws IOException {
        getConsoleUI().setConnectParentAndChild();
    }
}
