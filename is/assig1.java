public class assig1 {
    public static void main(String[] args) {
        String str = "Hello\nWorld";

        System.out.println("Original String: " + str);

        System.out.println("\nAfter AND with 127:");
        for (int i = 0; i < str.length(); i++) {
            System.out.print((char)(str.charAt(i) & 127));
        }

        System.out.println("\n\nAfter XOR with 127:");
        for (int i = 0; i < str.length(); i++) {
            System.out.print((char)(str.charAt(i) ^ 127));
        }

        System.out.println();
    }
}
