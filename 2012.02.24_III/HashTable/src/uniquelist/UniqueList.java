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
    @Override
    public void addToList(T value) throws AlreadyExists {

        if (null != this.find(value)) {
            throw new AlreadyExists();
        } else {
            super.addToList(value);
        }
    }
}
