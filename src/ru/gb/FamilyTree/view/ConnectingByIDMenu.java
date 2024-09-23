package ru.gb.FamilyTree.view;

import ru.gb.FamilyTree.view.commands.*;

public class ConnectingByIDMenu extends Menu {

    public ConnectingByIDMenu(ConsoleUI consoleUI, Integer id) {
        super(consoleUI);
        super.commands.add(new AddFatherById(consoleUI, id));
        super.commands.add(new AddMotherById(consoleUI, id));
        super.commands.add(new AddChildById(consoleUI, id));
        super.commands.add(new AddSpouseById(consoleUI, id));
        super.commands.add(new ShowMainMenu(consoleUI));
    }

}
