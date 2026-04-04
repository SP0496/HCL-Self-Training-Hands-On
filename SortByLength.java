import java.util.*;

public class SortByLength {
    public static void main(String[] args) {
        String[] arr = {"apple", "kiwi", "banana", "fig", "grape"};

        Arrays.sort(arr, (a, b) -> a.length() - b.length());

        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}