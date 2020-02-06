import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Problem:
 * Convert an infix expression to postfix expression
 * 
 * Solution:
 * 1. Scan the infix expression from left to right.
 * 2. If the scanned character is an operand, output it.
 * 3. Else,
	3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack
		(or the stack is empty or the stack contains a ‘(‘ ), push it.
	3.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. 
	    After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
 * 4. If the scanned character is an ‘(‘, push it to the stack.
 * 5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, and discard both the parenthesis.
 * 6. Repeat steps 2-6 until infix expression is scanned.
 * 7. Print the output
 * 8. Pop and output from the stack until it is not empty.
 * 
 * References:
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 * https://codeburst.io/conversion-of-infix-expression-to-postfix-expression-using-stack-data-structure-3faf9c212ab8
 */
public class InfixToPostfixExpression {

	// A utility function to return precedence of a given operator
	static int getPrecedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		default:
			return -1;
		}

	}

	// method that converts given infix expression to postfix expression.
	static String convertInfixToPostfix(String exp) {

		StringBuilder result = new StringBuilder();

		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);

			// If the scanned character is an operand, add it to output.
			if (Character.isLetterOrDigit(c))
				result.append(c);

			// If scanned character is an '(', push it to the stack.
			else if (c == '(')
				stack.push(c);

			// If scanned character is an ')', pop from the stack until an'(' is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result.append(stack.pop());

				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					return "Invalid Expression";
			}
			
			// an operator is encountered
			else {
				while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
					if (stack.peek() == '(')
						return "Invalid Expression";
					result.append(stack.pop());
				}
				stack.push(c);
			}

		}

		// pop all the operators from the stack
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result.append(stack.pop());
		}
		
		return result.toString();
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convertInfixToPostfix(exp));
	}
}
