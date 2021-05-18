package Exercise1_4;

/**
 * <h1>Implementing An ADT</h1>
 *
 * @author Miguel Emmara - 18022146
 */
public class ImplementingAnADT {
    public static void main(String[] args) {
        Driver driver = new Driver();
        System.out.println("Generating Element from 1 to 20");
        System.out.println(driver.getList());

        Integer integer = Driver.randomObtainableArrayList.getRandom();
        System.out.println("\nRetrieved Random Element: " + integer);

        System.out.println("\nRemoved Random Element");
        Driver.randomObtainableArrayList.removeRandom();
        System.out.println(Driver.randomObtainableArrayList);
    }
}
