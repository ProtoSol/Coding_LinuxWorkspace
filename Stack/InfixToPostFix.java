package Stack;

import java.util.Stack;

public class InfixToPostFix {
    
    public static void main(String[] args) {
        String infix = "a+b*c+(d-e)";
        String postfix = convertInfixToPostfix(infix);
        System.out.println("Postfix: " + postfix);
    }

    public static String convertInfixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()) && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            } else {
                postfix.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
