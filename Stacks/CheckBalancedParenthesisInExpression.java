import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem:
 * Given an expression string exp, write a program to examine whether the pairs 
 * and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * 
 * Input: exp = “[()]{}{[()()]()}”
   Output: Balanced

 * Input: exp = “[(])”
   Output: Not Balanced
 * 
 * Solution:
 * Traverse the expression string.
 * If the current character is a opening bracket then push it to stack.
 * If the current character is a closing bracket then pop from stack 
 * and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
 * After complete traversal, if there is some starting bracket left in stack then “not balanced”.
 * 
 * References:
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * https://www.techiedelight.com/check-given-expression-balanced-expression-not/
*
*/

public class CheckBalancedParenthesisInExpression {
	
	// Function to check if given expression is balanced or not
		public static boolean checkExpression(String exp)
		{
			// take an empty stack of characters
			Stack<Character> stack = new Stack<>();
			
			Map<Character, Character> charMap = new HashMap<>();
			charMap.put('(', ')');
			charMap.put('[', ']');
			charMap.put('{', '}');

			// traverse the input expression
			for (int i = 0; i < exp.length(); i++)
			{
				// if char in the expression is an opening brace, 
				// push it to the stack
				if (charMap.containsKey(exp.charAt(i)))
					stack.push(exp.charAt(i));

				// if current char in the expression is a closing brace
				// return false if mismatch is found
				else if (!stack.empty() && stack.pop().equals(exp.charAt(i)))
						return false;
			}

			// expression is balanced only if stack is empty at this point
			return stack.empty();
		}

		public static void main(String[] args)
		{
			String exp = "{()}[{}]";

			if (checkExpression(exp)) {
				System.out.println("The expression is balanced");
			} else {
				System.out.println("The expression is not balanced");
			}
		}

}
