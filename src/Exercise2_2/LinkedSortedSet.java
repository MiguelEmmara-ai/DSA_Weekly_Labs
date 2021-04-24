package Exercise2_2;

import java.util.Collection;

/**
 * <h1>Linked Sorted Set</h1>
 *
 * @author  Miguel Emmara - 18022146
 */
public class LinkedSortedSet<E extends Comparable<E>> extends LinkedSet<E> {
    public LinkedSortedSet(Collection<? extends E> c) {
        super(c);
    }

    public LinkedSortedSet() {
    }

    @Override
    public boolean add(E o) {
        boolean result = true;
        Node<E> newNode = new Node<E>(o);

        if (contains(o)) {
            result = false;
        } else if (firstNode == null || firstNode.element.compareTo(newNode.element) > 0) {
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            Node<E> currentNode = firstNode;
            boolean finished = false;

            while (currentNode.next != null) {
                if (newNode.element.compareTo(currentNode.next.element) < 0) {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    numElements++;
                    finished = true;
                    break;
                }
                currentNode = currentNode.next;
            }
            if (!finished) {
                currentNode.next = newNode;
                numElements++;
            }
        }
        return result;
    }
}