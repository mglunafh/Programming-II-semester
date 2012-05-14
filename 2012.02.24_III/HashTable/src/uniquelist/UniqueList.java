/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquelist;

import list.*;

/**
 *
 * @author FedorUvarychev
 */
public class UniqueList<T> extends List<T> {

    public UniqueList() {
        super();
    }

    /**
     * Method, which checks, whether the list contains a given value or not. If
     * yes, throws exception, if not, adds element to end.
     *
     * @param value
     * @throws AlreadyExists if given value has been previously added to list.
     */
    public void addToList(T value) throws AlreadyExists {
        if (this.isEmpty()) {
            this.addToEnd(value);
        } else {
            try {
                ListElement temp = this.hd();
                while (null != temp) {
                    if (temp.getValue() == value) {
                        throw new AlreadyExists();
                    } else {
                        temp = temp.getNext();
                    }
                }
                this.addToEnd(value);

            } catch (EmptyListException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method, which finds a given value in the unique list.
     * @param value
     * @return a position, consisting of element to be found.
     * @throws DoesNotExist if there is not this element.
     */
    public ListElement find(T value) throws DoesNotExist {
        ListElement temp = null;
        try {
            temp = this.hd();
        } catch (EmptyListException e) {
            throw new DoesNotExist();
        }

        while (temp != null) {
            if (temp.getValue() == value) {
                return temp;
            }
            temp = temp.getNext();
        }
        throw new DoesNotExist();
    }
}
