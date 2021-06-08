package Exercise5_1;

/**
 * Created by Miguel Emmara - 18022146
 */
public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        Student stu = null;
        for (int i = 1; i <= 10; i++) {
            stu = new Student("Student " + i, "LastName");
            ht.put(stu.FullName(), stu);
        }
        //stu = ht.get("Student " + 1);

        System.out.println(ht);
    }
}