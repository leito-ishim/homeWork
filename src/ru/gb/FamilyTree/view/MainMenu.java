package ru.gb.FamilyTree.view;

import ru.gb.FamilyTree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        super.commands.add(new AddPerson(consoleUI));
        super.commands.add(new GetFamilyTreeInfo(consoleUI));
        super.commands.add(new SetConnectParentAndChild(consoleUI));
        super.commands.add(new AddSpouses(consoleUI));
        super.commands.add(new AddConnectById(consoleUI));
        super.commands.add(new ShowSortMenu(consoleUI));
        super.commands.add(new SaveToFile(consoleUI));
        super.commands.add(new LoadFromFile(consoleUI));
        super.commands.add(new Finish(consoleUI));
    }


}
