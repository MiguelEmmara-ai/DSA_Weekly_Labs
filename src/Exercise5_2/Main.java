package Exercise5_2;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Miguel Emmara - 18022146
 */
public class Main {
    public static void main(String[] args) {
        Map<StudentID, Student> map = new HashMap<>();


        map.put(new StudentID("123456"), new Student("Taupo", Calendar.MAY, "Miguel"));
    }

    private static class StudentID {
        private final String studentID;

        public StudentID(String studentID) {
            this.studentID = studentID;
        }

        @Override
        public int hashCode() {
            return studentID.charAt(0) - 'a';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final StudentID other = (StudentID) obj;
            return Objects.equals(this.studentID, other.studentID);
        }
    }

    private static class Student {
        private final String address;
        private final int birthday;
        private final String name;

        public Student(String address, int birthday, String name) {
            this.address = address;
            this.birthday = birthday;
            this.name = name;
        }
    }
}
