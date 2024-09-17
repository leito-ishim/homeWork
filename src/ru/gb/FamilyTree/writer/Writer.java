package ru.gb.FamilyTree.writer;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable) throws Exception;
    Object load();
    void setFileName(String fileName);
}
