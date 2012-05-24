/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package set;

import list.*;
import uniquelist.*;
import list.List.ListIterator;

/**
 *
 * @author Fedor Uvarychev Создать генерик-класс, реализующий АТД "Множество",
 * обладающий операциями добавления, удаления элемента, проверки на
 * принадлежность множеству, пересечения и объединения множеств.
 */
public class Set<T> {

    public Set() {
        this.container = new UniqueList<>();
    }

    /**
     * Adds an element to set.
     *
     * @param value
     */
    public void addElement(T value) {
        try {
            container.addToList(value);
        } catch (AlreadyExists e) {
        }
    }

    /**
     * Removeth awaye the element from the set.
     *
     * @param value
     */
    public void deleteElement(T value) {
        Object pos = container.find(value);
        if (null != pos) {
            container.delete(pos);
        }
    }

    /**
     * Checks, if the element belongs to set.
     *
     * @param value
     * @return
     */
    public boolean ifBelongs(T value) {
        return (null != container.find(value));
    }

    /**
     * Puts elements of the set to list.
     *
     * @return
     */
    public List<T> toUniqueList() {
        UniqueList<T> result = new UniqueList<>();
        for (T element : container) {
            result.addToList(element);
        }
        return result;
    }

    /**
     * Puts elements of the list to set.
     *
     * @param list
     * @return
     */
    public Set<T> toSet(List<T> list) {
        Set<T> result = new Set<>();
        for (T element : list) {
            result.addElement(element);
        }
        return result;
    }

    /**
     * Intersects two sets.
     *
     * @param otherSet
     * @return intersection of the sets without harming them.
     */
    public Set<T> intersect(Set<T> otherSet) {
        Set<T> intersect = new Set<>();
        ListIterator it = this.container.iterator();
        while (it.hasNext()) {
            T temp = (T) it.next();
            if (otherSet.ifBelongs(temp)) {
                intersect.addElement(temp);
            }
        }

        return intersect;
    }

    /**
     * Unites two sets.
     *
     * @param otherSet
     * @return the union of tho sets, without damaging them.
     */
    public Set<T> union(Set<T> otherSet) {
        Set<T> un = new Set<>();
        for (T element : container) {
            un.addElement(element);
        }
        for (T element : otherSet.toUniqueList()) {
            un.addElement(element);
        }
        return un;
    }
    private UniqueList<T> container;
}
