// Count word occurrences from a  ile using File Handling APIs 

import java.io.*;
import java.util.*;

public class Problem5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user for file path
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        // Map to store word count
        HashMap<String, Integer> wordCount = new HashMap<>();

        try {
            // FileReader + BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                // Split into words
                String words[] = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    // Count occurrences
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            br.close();

            // Display results
            System.out.println("\nWord Occurrences:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }

        sc.close();
    }
}