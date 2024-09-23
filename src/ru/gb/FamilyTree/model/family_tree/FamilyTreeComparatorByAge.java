package ru.gb.FamilyTree.model.family_tree;

import java.util.Comparator;

public class FamilyTreeComparatorByAge<E extends TreeNode> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}