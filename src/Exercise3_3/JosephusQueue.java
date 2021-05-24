package Exercise3_3;

import java.util.Deque;

/**
 * Created by Miguel Emmara - 18022146
 */
public class JosephusQueue {
    private final Deque<Integer> elements;
    private int gap;

    public JosephusQueue(Deque<Integer> elements) {
        this.elements = elements;
    }

    public String removeElements() {
        StringBuilder removeOrder = new StringBuilder(elements.size());
        int count = 1;
        while (!elements.isEmpty()) {
            if (count % gap == 0) {
                removeOrder.append(elements.getFirst()).append(" ");
                elements.removeFirst();
            } else {
                Integer hoppedElement = elements.getFirst();
                elements.removeFirst();
                elements.add(hoppedElement);
            }
            count++;

        }
        return removeOrder.toString();
    }

    public void setGap(int gap) {
        this.gap = gap;
    }
}