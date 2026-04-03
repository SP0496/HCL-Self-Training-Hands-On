import java.util.*;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        List<Character> stack = new ArrayList<>();

        for (char ch : s.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } 
            else {
                // If stack empty → invalid
                if (stack.isEmpty()) return false;

                // Get top element
                char top = stack.get(stack.size() - 1);

                // Check matching
                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    // Pop
                    stack.remove(stack.size() - 1);
                } 
                else {
                    return false;
                }
            }
        }

        // If empty → balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({[]})";

        if (isBalanced(s)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}