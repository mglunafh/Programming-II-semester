
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Fedor Uvarychev
 */
public class PriorityQueue<Type> {

    /**
     *
     * @param value
     * @param priority
     */
    public void enqueue(Type value, int priority) {
        TwoTuple newPair = new TwoTuple(value, priority);
        priorQueue.addLast(newPair);
    }

    /**
     *
     * @return a value with maximal priority.
     * @throws EmptyQueueException when queue is empty.
     */
    public Type dequeue() throws EmptyQueueException {
        if (priorQueue.isEmpty()) {
            throw new EmptyQueueException();
        }
        ListIterator iterator = priorQueue.listIterator();
        TwoTuple<Type, Integer> withMaxPriority = priorQueue.getFirst();

        for (TwoTuple<Type, Integer> pair : priorQueue) {
            if (pair.priority > withMaxPriority.priority) {
                withMaxPriority = pair;
            }
        }

        return withMaxPriority.value;
    }

    /**
     *
     * @param <Type>
     * @param <Integer>
     */
    private class TwoTuple<Type, Integer> {

        private final Type value;
        private final Integer priority;

        public TwoTuple(Type val, Integer priority) {
            this.value = val;
            this.priority = priority;
        }
    }
    private LinkedList<TwoTuple<Type, Integer>> priorQueue = new LinkedList<TwoTuple<Type, Integer>>();
}
