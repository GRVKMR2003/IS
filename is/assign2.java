import java.util.Scanner;

public class assign2ga {

    // Encrypt: write row-wise, read column-wise using a 2D array
    public static String encrypt(String text, int key) {
        int len = text.length();
        int rows = (len + key - 1) / key; // Calculate the number of rows required

        // Create a 2D array to store the text
        char[][] grid = new char[rows][key];

        // Fill the grid row-wise with the input text
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < key; col++) {
                if (index < len) {
                    grid[row][col] = text.charAt(index++);
                } else {
                    grid[row][col] = ' '; // Fill remaining spaces with ' ' (space character)
                }
            }
        }

        // Read the grid column-wise to generate the cipher text
        StringBuilder cipher = new StringBuilder();
        for (int col = 0; col < key; col++) {
            for (int row = 0; row < rows; row++) {
                cipher.append(grid[row][col]);
            }
        }

        return cipher.toString();
    }

    // Decrypt: reverse of encryption, use 2D array and fill column-wise
    public static String decrypt(String cipher, int key) {
        int len = cipher.length();
        // Calculate the number of rows needed for the 2D array
        int rows = (len + key - 1) / key;

        // Initialize the 2D array with spaces
        char[][] grid = new char[rows][key];
        int index = 0;

        // Fill the grid column-wise with cipher text
        for (int col = 0; col < key; col++) {
            for (int row = 0; row < rows; row++) {
                if (index < len) {
                    grid[row][col] = cipher.charAt(index++);
                } else {
                    grid[row][col] = ' '; // Fill remaining spaces with ' '
                }
            }
        }

        // Now read the grid row-wise to reconstruct the plaintext
        StringBuilder plain = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < key; col++) {
                plain.append(grid[row][col]);
            }
        }

        // Remove trailing spaces (if any) from the plaintext
        return plain.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter plain text (no spaces): ");
        String text = scanner.next();
        System.out.print("Enter key (e.g., 4): ");
        int key = scanner.nextInt();

        // Encrypt the text
        String encrypted = encrypt(text, key);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt the text back to original
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}
