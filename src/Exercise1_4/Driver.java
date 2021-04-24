package Exercise1_4;

/**
 * <h1>Driver</h1>
 *
 * @author  Miguel Emmara - 18022146
 */
public class Driver {
    static RandomObtainableArrayList<Integer> randomObtainableArrayList;

    public Driver() {
        setRandomObtainableArrayList(new RandomObtainableArrayList<>());
        for (int i = 1; i <= 20; i++) {
            getRandomObtainableArrayList().add(i);
        }
    }

    private static RandomObtainableArrayList<Integer> getRandomObtainableArrayList() {
        return randomObtainableArrayList;
    }

    private static void setRandomObtainableArrayList(RandomObtainableArrayList<Integer> randomObtainableArrayList) {
        Driver.randomObtainableArrayList = randomObtainableArrayList;
    }

    public RandomObtainableArrayList getList() {
        return this.getRandomObtainableArrayList();
    }
}
