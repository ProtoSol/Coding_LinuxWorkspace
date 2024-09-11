package Stack;
import java.util.Stack;
// PostfixToInfix
public class PostfixToInfix {
    public static void main(String[] args) {
        String postfix = "ab*c+";
        String infix = convertPostfixToInfix(postfix);
        System.out.println("Infix: " + infix);
    }

    public static String convertPostfixToInfix(String postfix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder infix = new StringBuilder();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    infix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()) && stack.peek() != '(') {
                    infix.append(stack.pop());
                }
                stack.push(ch);
            } else {
                infix.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            infix.append(stack.pop());
        }

        return infix.toString();
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
}

