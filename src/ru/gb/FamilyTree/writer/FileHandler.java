package ru.gb.FamilyTree.writer;

import ru.gb.FamilyTree.family_tree.FamilyTree;

import java.io.*;
import java.time.LocalDate;

public class FileHandler implements Writer {
    private String fileName = "src/ru/gb/FamilyTree/writer/writer";

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void save(Serializable serializable) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
    }
    @Override
    public Object load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.fileName))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
