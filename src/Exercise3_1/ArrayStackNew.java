package Exercise3_1;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Miguel Emmara
 */
public class ArrayStackNew < E > implements StackADT < E > {
    private final int INITIAL_CAPACITY = 20;
    protected int num_elements;
    protected E[] elements;

    // default constructor that creates a new stack
    // that is initially empty
    @SuppressWarnings("unchecked")
    public ArrayStackNew() {
        num_elements = 0;
        elements = (E[])(new Object[INITIAL_CAPACITY]);
    }

    // constructor for creating a new stack which
    // initially holds the elements in the collection c
    public ArrayStackNew(Collection < ?extends E > c) {
        this();
        for (E element: c)
            push(element);
    }

    // Adds one element to the top of this stack
    public void push(E element) {
        if (num_elements >= elements.length) expandCapacity();
        shiftRight();
        elements[0] = element;
        num_elements++;
    }

    // removes and returns the top element from this stack
    public E pop() throws NoSuchElementException {
        if (num_elements > 0) {
            E topElement = elements[0];
            shiftLeft();
            elements[num_elements - 1] = null;
            num_elements--;
            return topElement;
        } else {
            throw new NoSuchElementException();
        }
    }

    // returns without removing the top element of this stack
    public E peek() throws NoSuchElementException {
        if (num_elements > 0) return elements[num_elements - 1];
        else throw new NoSuchElementException();
    }

    // returns true if this stack contains no elements
    public boolean isEmpty() {
        return (num_elements == 0);
    }

    // returns the number of elements in this stack
    public int size() {
        return num_elements;
    }

    // returns a string representation of the stack from top to bottom
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (int i = num_elements - 1; i >= 0; i--) {
            output.append(elements[i]);
            if (i > 0) output.append(",");
        }
        output.append("]");
        return output.toString();
    }

    // helper method which doubles the current size of the array
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        E[] largerArray = (E[])(new Object[elements.length * 2]); //unchecked
        // copy the elements array to the largerArray
        if (num_elements >= 0) System.arraycopy(elements, 0, largerArray, 0, num_elements);
        elements = largerArray;
    }

    // shifting elements along whenever an element is pushed or popped
    private void shiftRight() {
        if (num_elements + 1 >= 0) System.arraycopy(elements, 0, elements, 1, num_elements + 1);
    }

    // // shifting elements along whenever an element is pushed or popped
    private void shiftLeft() {
        if (num_elements - 1 >= 0) System.arraycopy(elements, 1, elements, 0, num_elements - 1);
    }

    public static void main(String[] args) {
        ArrayStackNew < Integer > arrayStackNew = new ArrayStackNew < >();
        Scanner scanner = new Scanner(System. in );
        boolean stop = false;
        int counter = 1;
        int input;
        int output;

        System.err.println();
        System.out.print("Enter your choice ");
        do {
            try {
                System.out.println("\n\t1. Push " + "\n\t2. Pop " + "\n\t3. Peek " + "\n\t4. Print " + "\n\t5. Exit");
                System.out.print("\nAnswer> ");
                input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1:
                        System.out.print("How Many Elements: ");
                        int elements = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < elements; i++) {
                            System.out.print("Elements " + counter + ": ");
                            int input_element = scanner.nextInt();
                            arrayStackNew.push(input_element);
                            counter++;
                        }
                        System.out.println();
                        break;

                    case 2:
                        try {
                            output = arrayStackNew.pop();
                            System.out.println("Popped " + output);
                            counter--;
                        } catch(NoSuchElementException e) {
                            System.out.println("Stack is empty");
                        }
                        System.out.println(arrayStackNew);
                        System.out.println();
                        break;

                    case 3:
                        try {
                            output = arrayStackNew.peek();
                            System.out.println("Peek " + output);
                        } catch(NoSuchElementException e) {
                            System.out.println("Stack empty");
                        }
                        System.out.println(arrayStackNew);
                        System.out.println();
                        break;

                    case 4:
                        if (arrayStackNew.size() <= 0) {
                            System.out.println("Stack empty");
                        }
                        System.out.println(arrayStackNew);
                        System.out.println();
                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        stop = true;
                        break;

                    default:
                        System.err.println("Please Answer 1 - 5");
                }
            } catch(InputMismatchException e) {
                System.err.println("Please Input Only Numbers");
                scanner.nextLine();
            }
        } while (! stop );
    }
}