package ru.gb.FamilyTree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T person);
    boolean addParent(T person);
    String getName();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    List<T> getChildren();
    List<T> getParents();
    T getSpouse();
    void setSpouse(T person);
    String getGender();
    int getAge();
}
