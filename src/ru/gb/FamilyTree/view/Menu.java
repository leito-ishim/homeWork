package ru.gb.FamilyTree.view;

import ru.gb.FamilyTree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    public List<Command> commands;

    public Menu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
    }

    public String menu() {
        StringBuilder output = new StringBuilder();
        output.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            output.append(i+1);
            output.append(". ");
            output.append(commands.get(i).getDescription());
            output.append("\n");
        }
        return output.toString();
    }

    public void execute(int choice) throws IOException {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size(){
        return commands.size();
    }
}
