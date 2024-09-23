package ru.gb.FamilyTree.model.family_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends TreeNode> implements Iterator<E> {
    private int index = 0;
    private List<E> persons;


    public FamilyTreeIterator(List<E> persons) {
        this.persons = persons;
    }

    @Override
    public boolean hasNext() {
        return persons.size() > index;
    }

    @Override
    public E next() {
        return persons.get(index++);
    }
}
