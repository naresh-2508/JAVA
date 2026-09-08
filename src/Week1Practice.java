import java.util.Arrays;

public class Week1Practice {

    public static void main(String[] args) {

        System.out.println("1. Fibonacci");
        fibonacci(10);

        System.out.println("\n2. Prime Check");
        System.out.println("29 is prime: " + isPrime(29));
        System.out.println("15 is prime: " + isPrime(15));

        System.out.println("\n3. Reverse Integer");
        System.out.println("Reverse of 1234: " + reverse(1234));

        System.out.println("\n4. FizzBuzz");
        fizzBuzz(15);

        System.out.println("\n5. Min and Max");
        int[] a = {5, 2, 9, 1, 7, 6};
        minMax(a);

        System.out.println("\n6. Reverse Array");
        int[] b = {1, 2, 3, 4, 5};
        reverseArray(b);
        System.out.println(Arrays.toString(b));

        System.out.println("\n7. Two Sum");
        int[] c = {2, 7, 11, 15};
        twoSum(c, 9);

        System.out.println("\n8. Remove Duplicates");
        int[] d = {1, 1, 2, 2, 3, 4, 4, 5};
        int n = removeDuplicates(d);

        for (int i = 0; i < n; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();

        System.out.println("\n9. Palindrome");
        System.out.println("Racecar: " + isPalindrome("Racecar"));

        System.out.println("\n10. Vowels and Consonants");
        count("Hello World");

        System.out.println("\n11. Anagram");
        System.out.println("listen and silent: " +
                isAnagram("listen", "silent"));

        System.out.println("\n12. First Unique Character");
        System.out.println("swiss: " + firstUnique("swiss"));
    }

    static void fibonacci(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    static int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            int d = n % 10;
            rev = rev * 10 + d;
            n = n / 10;
        }

        return rev;
    }

    static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {

            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    static void minMax(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int min = a[0];
        int max = a[0];

        for (int x : a) {
            if (x < min) {
                min = x;
            }

            if (x > max) {
                max = x;
            }
        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

    static void reverseArray(int[] a) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }
    }

    static void twoSum(int[] a, int target) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {

                if (a[i] + a[j] == target) {
                    System.out.println(
                            a[i] + " + " + a[j] + " = " + target
                    );
                    return;
                }
            }
        }

        System.out.println("No pair found");
    }

    static int removeDuplicates(int[] a) {

        if (a.length == 0) {
            return 0;
        }

        int j = 0;

        for (int i = 1; i < a.length; i++) {

            if (a[i] != a[j]) {
                j++;
                a[j] = a[i];
            }
        }

        return j + 1;
    }

    static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    static void count(String s) {

        int v = 0;
        int c = 0;

        s = s.toLowerCase();

        for (char ch : s.toCharArray()) {

            if (ch >= 'a' && ch <= 'z') {

                if ("aeiou".indexOf(ch) >= 0) {
                    v++;
                } else {
                    c++;
                }
            }
        }

        System.out.println("Vowels = " + v);
        System.out.println("Consonants = " + c);
    }

    static boolean isAnagram(String s1, String s2) {

        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    static char firstUnique(String s) {

        int[] count = new int[256];

        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        for (char ch : s.toCharArray()) {
            if (count[ch] == 1) {
                return ch;
            }
        }

        return '_';
    }
}