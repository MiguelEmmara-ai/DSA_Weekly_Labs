package Exercise5_1;

/**
 * Created by Miguel Emmara - 18022146
 */
public class Student {
    private final String firstName;
    private final String secondName;

    Student(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String FullName() {
        return firstName + " " + secondName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
