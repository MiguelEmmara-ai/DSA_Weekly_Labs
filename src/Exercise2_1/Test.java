package Exercise2_1;

/**
 * Created by Miguel Emmara
 */
public class Test {
    public static void main(String[] args) {
        ArraySet<Integer> arraySet = new ArraySet<>();
        long start;
        long end;
        int counter = 0;
        int n = 1;

        while (counter < 1000) {
            counter += 100;

            start = System.nanoTime();
            arraySet.add(n);
            end = System.nanoTime();
            System.out.println("Add method takes " + (end - start) + " nano seconds\n");

            start = System.nanoTime();
            arraySet.contains(n);
            end = System.nanoTime();
            System.out.println("Contains method takes " + (end - start) + " nano seconds\n");

            start = System.nanoTime();
            arraySet.remove(n);
            end = System.nanoTime();
            System.out.println("Remove method takes " + (end - start) + " nano seconds\n");

            System.out.println("++++++++++++++++++++++++++++");
            n++;
        }
    }
}
