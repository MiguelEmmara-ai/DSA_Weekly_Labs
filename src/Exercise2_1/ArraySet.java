package Exercise2_1;

/**
 * Created by Miguel Emmara
 */
public class ArraySet<E> implements ArraySetADT<E> {
    private static final int FIXED_CAPACITY = 10;
    private final Object[] items;
    private Object n;
    private int size;

    public ArraySet() {
        this.items = new Object[FIXED_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(Object item) {
        for (int i = 0; i < items.length; i++) {
            this.items[i] = item;
        }
        size++;
    }

    @Override
    public void remove(Object item) {
        int i;
        for (i = 0; i < items.length; i += 1) {
            if (this.items[i] == item)
                break;
        }
        while (i < items.length - 1) {
            items[i] = items[i + 1];
            i += 1;
        }
        items[i] = 0;
        size -= 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object contains(Object item) {
        for (int i = 0; i < items.length; i += 1) {
            if (this.items[i] == item)
                return i;
        }
        return -1;
    }
}
