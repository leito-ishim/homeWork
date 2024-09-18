package ru.gb.FamilyTree.family_tree;

import ru.gb.FamilyTree.person.Person;

import java.util.Comparator;

public class FamilyTreeComparatorByGender<E extends TreeNode> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
