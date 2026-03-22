// Implement Cipher system using Abstract class and method overriding 

import java.util.Scanner;

// Abstract Class
abstract class Cipher {
    String text;

    Cipher(String text) {
        this.text = text;
    }

    // Abstract methods
    abstract String encrypt();
    abstract String decrypt();
}

// Derived Class (Caesar Cipher)
class CaesarCipher extends Cipher {
    int shift;

    CaesarCipher(String text, int shift) {
        super(text);
        this.shift = shift;
    }

    // Override encrypt method
    String encrypt() {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }

            result += ch;
        }
        return result;
    }

    // Override decrypt method
    String decrypt() {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base - shift + 26) % 26 + base);
            }

            result += ch;
        }
        return result;
    }
}

// Main Class
public class Problem6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        CaesarCipher cc = new CaesarCipher(text, shift);

        String encrypted = cc.encrypt();
        System.out.println("Encrypted Text: " + encrypted);

        // Use encrypted text for decryption
        CaesarCipher cc2 = new CaesarCipher(encrypted, shift);
        String decrypted = cc2.decrypt();
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}