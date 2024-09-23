package ru.gb.FamilyTree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
//    private String nameTree;
    private long personId;
    private final List<E> familyMembersList;

    public FamilyTree() {
        familyMembersList = new ArrayList<>();
    }

    public FamilyTree(List<E> familyMembersList) {
        this.familyMembersList = familyMembersList;
    }

    public boolean addPerson(E person) {
        if (person == null) {
            return false;
        }
        if (!familyMembersList.contains(person)) {
            familyMembersList.add(person);
            person.setId(personId++);

            addToParents(person);
            addToChildren(person);
            return true;
        }
        return false;
    }

    private void addToParents(E person) {
        for (E parent: person.getParents()) {
            parent.addChild(person);
        }
    }

    private void addToChildren(E person) {
        for (E child: person.getChildren()) {
            child.addParent(person);
        }
    }

    public List<E> getSiblings(long personId) {
        E person = getById(personId);
        if (person == null) {
            return null;
        }
        List<E> siblings = new ArrayList<>();
        for (E parent: person.getParents()) {
            for (E child: parent.getChildren()) {
                if (!child.equals(person)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public E getById(long personId) {
        for (E person: familyMembersList) {
            if (person.getId() == personId) {
                return person;
            }
        }
        return null;
    }

    public List<E> getByName(String name) {
        List<E> persons = new ArrayList<>();
        for (E person: familyMembersList) {
            if (person.getName().equals(name)) {
                persons.add(person);
            }
        }
        return persons;
    }

    public boolean setAddSpouses(long personId1, long personId2) {
        if (checkId(personId1) && checkId(personId2)) {
            E person1 = getById(personId1);
            E person2 = getById(personId2);
            setAddSpouses(person1, person2);
            return true;
        }
        return false;
    }

    public boolean setAddSpouses(E person1, E person2) {
        if (person1 != null && person2 != null) {
            person1.setSpouse(person2);
            person2.setSpouse(person1);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSpouses(E person1, E person2) {
        if (person1 != null && person2 != null) {
            person1.setSpouse(null);
            person2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeSpouses(long personId1, long personId2) {
        if (checkId(personId1) && checkId(personId2)) {
            E person1 = getById(personId1);
            E person2 = getById(personId2);
            removeSpouses(person1, person2);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long personId) {
        if (checkId(personId)) {
            E person = getById(personId);
            return familyMembersList.remove(person);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < personId && id >=0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Количество членов семьи: ").append(familyMembersList.size()).append("\n");
        for (E person: familyMembersList) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(familyMembersList);
    }

    public void sortByName() {
        familyMembersList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByGender() {
        familyMembersList.sort(new FamilyTreeComparatorByGender<>());
    }

    public void sortByAge() {
        familyMembersList.sort(new FamilyTreeComparatorByAge<>());
    }


//    public String showAllFamilyMembers() {
//        StringBuilder sb = new StringBuilder();
//        for (Person person : familyMembersList) {
//            sb.append(person.toString()).append("\n");
//        }
//        return sb.toString();
//    }
//
//    public List<Person> getFamilyMembers() {
//        return familyMembersList;
//    }
//
//    public Person getFamilyMember(String name) {
//        for (Person person : familyMembersList) {
//            if (person.getName().equals(name)) {
//                return person;
//            }
//        }
//        return null;
//    }
//
//    public void setFatherForPerson(Person father, Person child) {
//        if (father != child) {
//            if (father.getGender().equals("Male")) {
//                if (father.getAge() - child.getAge() >= 16) {
//                    father.addChild(child);
//                    child.setFather(father);
//                    System.out.println("Добавлена связь: " + father + " отец -> " + child);
//                    if (!familyMembersList.contains(father)) {
//                        familyMembersList.add(father);
//                    }
//                    if (!familyMembersList.contains(child)) {
//                        familyMembersList.add(child);
//                    }
//                } else {
//                    System.out.println("Маленькая разница в возрасте. Не могут быть отцом и ребенком");
//                }
//            } else {
//                System.out.println("Отец должен быть мужчиной");
//            }
//
//        }
//    }
}
