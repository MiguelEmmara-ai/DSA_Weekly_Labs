package Exercise1_4;

import java.util.NoSuchElementException;

/**
 * <h1>Random Obtainable Interface Class</h1>
 *
 * @author  Miguel Emmara - 18022146
 */
public interface RandomObtainable <E> {
    public E getRandom() throws NoSuchElementException;
    public boolean removeRandom() throws UnsupportedOperationException;
}
