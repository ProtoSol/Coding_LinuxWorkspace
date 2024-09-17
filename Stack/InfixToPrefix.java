package Stack;

import java.util.Stack;

public class InfixToPrefix {

    public static String convertInfixToPrefix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = infix.length() - 1; i >= 0; i--) {
            // We are traversing from right to left
            char ch = infix.charAt(i);
            // The Roles of '(' and ')' are inverted
            if (ch == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }
                stack.pop();
            } else if (ch == ')') {
                stack.push(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                // Precedence is used to determine the order of operations
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    prefix.append(stack.pop());
                }
                stack.push(ch);
            } else {
                prefix.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String infix = "a+b*c+(d-e)";
        String prefix = convertInfixToPrefix(infix);
        System.out.println("Prefix: " + prefix);
    }
}

