// Implement CRUD operations using Collection API (ArrayList, HashMap, TreeMap) 

import java.util.*;

// Student class
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}

public class Problem3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Collections
        ArrayList<Student> list = new ArrayList<>();
        HashMap<Integer, Student> hashMap = new HashMap<>();
        TreeMap<Integer, Student> treeMap = new TreeMap<>();

        int choice;

        do {
            System.out.println("\n--- CRUD MENU ---");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: // CREATE
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    Student s = new Student(id, name);

                    list.add(s);
                    hashMap.put(id, s);
                    treeMap.put(id, s);

                    System.out.println("Record added!");
                    break;

                case 2: // READ
                    System.out.println("\nArrayList:");
                    for (Student st : list) {
                        System.out.println(st);
                    }

                    System.out.println("\nHashMap:");
                    for (Student st : hashMap.values()) {
                        System.out.println(st);
                    }

                    System.out.println("\nTreeMap (Sorted):");
                    for (Student st : treeMap.values()) {
                        System.out.println(st);
                    }
                    break;

                case 3: // UPDATE
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    // Update in ArrayList
                    for (Student st : list) {
                        if (st.id == uid) {
                            st.name = newName;
                        }
                    }

                    // Update in HashMap and TreeMap
                    if (hashMap.containsKey(uid)) {
                        hashMap.get(uid).name = newName;
                        treeMap.get(uid).name = newName;
                        System.out.println("Record updated!");
                    } else {
                        System.out.println("ID not found!");
                    }
                    break;

                case 4: // DELETE
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    // Remove from ArrayList
                    list.removeIf(st -> st.id == did);

                    // Remove from Maps
                    hashMap.remove(did);
                    treeMap.remove(did);

                    System.out.println("Record deleted!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}