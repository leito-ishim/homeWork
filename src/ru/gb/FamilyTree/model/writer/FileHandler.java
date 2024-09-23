package ru.gb.FamilyTree.model.writer;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath = "src/ru/gb/FamilyTree/test";

    public FileHandler() {
    }

    @Override
    public void save(Serializable serializable) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
    }
    @Override
    public Object load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void setFileName(String fileName) {
        this.filePath = fileName;
    }
}
