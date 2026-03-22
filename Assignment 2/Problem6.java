// Display all  iles of a given directory using File class 

import java.io.File;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take directory path as input
        System.out.print("Enter directory path: ");
        String path = sc.nextLine();

        File dir = new File(path);

        // Check if directory exists
        if (dir.exists() && dir.isDirectory()) {

            File[] files = dir.listFiles();

            System.out.println("\nFiles in the directory:");

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }

        } else {
            System.out.println("Invalid directory path!");
        }

        sc.close();
    }
}