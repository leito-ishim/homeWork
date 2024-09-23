package ru.gb.FamilyTree.model.writer;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable) throws Exception;
    Object load();
    void setFileName(String fileName);
}
