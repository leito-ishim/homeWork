package ru.gb.FamilyTree.view;

import ru.gb.FamilyTree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortMenu extends Menu {

    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        super.commands.add(new SortByName(consoleUI));
        super.commands.add(new SortByAge(consoleUI));
        super.commands.add(new SortByGender(consoleUI));
        super.commands.add(new ShowMainMenu(consoleUI));
    }

}
