package chapter2;

/**
 * A simple class which demonstrates how a set can be used
 */

public class SetExample {
    public static void main(String[] args) {
        ArraySet<String> bookTitles = new ArraySet<String>();
        bookTitles.add("Java Software Structures");
        bookTitles.add("Computer Graphics Using OpenGL");
        bookTitles.add("Java Software Structures");
        bookTitles.add("Introduction to Algorithms");
        bookTitles.add(null);
        System.out.println(bookTitles);
        bookTitles.remove("Computer Graphics Using OpenGL");
        System.out.println(bookTitles);
    }
}
