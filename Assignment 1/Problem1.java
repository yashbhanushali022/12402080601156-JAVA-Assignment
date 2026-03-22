/*Implement Array and String operations (Reverse, Sort, 
Search, Average, Maximum ) using class and objects */

import java.util.Arrays;

// Array Operations Class
class ArrayOperations {
    int[] arr;

    // Constructor
    ArrayOperations(int[] arr) {
        this.arr = arr;
    }

    // Reverse Array
    void reverseArray() {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }

    // Sort Array
    void sortArray() {
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Search Element
    void searchElement(int key) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element " + key + " found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }

    // Find Average
    void findAverage() {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double avg = (double) sum / arr.length;
        System.out.println("Average: " + avg);
    }

    // Find Maximum
    void findMaximum() {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum: " + max);
    }
}

// String Operations Class
class StringOperations {
    String str;

    // Constructor
    StringOperations(String str) {
        this.str = str;
    }

    // Reverse String
    void reverseString() {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("Reversed String: " + reversed);
    }

    // Search Character
    void searchChar(char ch) {
        if (str.indexOf(ch) != -1) {
            System.out.println("Character '" + ch + "' found in string.");
        } else {
            System.out.println("Character not found.");
        }
    }
}

// Main Class
public class Problem1 {
    public static void main(String[] args) {

        int[] numbers = {12, 45, 7, 23, 89};  // ✅ Changed values

        // Array Operations
        ArrayOperations obj = new ArrayOperations(numbers);
        obj.reverseArray();
        obj.sortArray();
        obj.searchElement(23);   // ✅ Changed search value
        obj.findAverage();
        obj.findMaximum();

        // String Operations
        StringOperations strObj = new StringOperations("JavaProgram"); // ✅ Changed string
        strObj.reverseString();
        strObj.searchChar('P'); // ✅ Changed character
    }
}