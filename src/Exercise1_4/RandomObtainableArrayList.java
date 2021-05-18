package Exercise1_4;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * <h1>Random Obtainable ArrayList</h1>
 *
 * @author Miguel Emmara - 18022146
 */
final class RandomObtainableArrayList<E> extends ArrayList<E> implements RandomObtainable<E> {
    private final Random randomNumber;

    public RandomObtainableArrayList() {
        super();
        randomNumber = new Random();
    }

    @Override
    public E getRandom() throws NoSuchElementException {
        return this.get(randomNumber.nextInt(this.size()));
    }

    @Override
    public boolean removeRandom() throws UnsupportedOperationException {
        boolean isRemove = false;
        int size = this.size();

        if (size != 0) {
            int number = randomNumber.nextInt(size);
            this.remove(number);
            System.out.println("Element " + ++number + " has been removed!");
            isRemove = true;
        }

        return isRemove;
    }
}