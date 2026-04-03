import java.util.*;

public class EvaluateRPN {

    public static int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();

        for (String token : tokens) {

            // Check if operator
            if (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/")) {

                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);

                int result = 0;

                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break;
                }

                stack.add(result);
            } 
            else {
                // number → push
                stack.add(Integer.parseInt(token));
            }
        }

        return stack.get(0);
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}