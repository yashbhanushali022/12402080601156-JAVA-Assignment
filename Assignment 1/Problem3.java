// Write a program demonstrating Wrapper classes and String vs StringBuffer 

public class Problem3 {
    public static void main(String[] args) {

        // WRAPPER CLASS DEMO

        int num = 25;

        // Autoboxing
        Integer obj = num;
        System.out.println("Primitive value: " + num);
        System.out.println("Wrapper Object value: " + obj);

        // Unboxing
        int unboxed = obj;
        System.out.println("Unboxed value: " + unboxed);

        // STRING (IMMUTABLE)

        String s = "Hello";
        s = s.concat(" World!");  // creates new object
        System.out.println("\nString after concatenation: " + s);

        // STRINGBUFFER (MUTABLE)

        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World!");  // modifies same object
        System.out.println("\nStringBuffer after append: " + sb);

        // Length and Capacity
        System.out.println("\nLength of StringBuffer: " + sb.length());
        System.out.println("Capacity of StringBuffer: " + sb.capacity());
    }
}