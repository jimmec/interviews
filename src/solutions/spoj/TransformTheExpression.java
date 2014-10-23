package solutions.spoj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TransformTheExpression {
	/**
	 * Converts a infix arithmetic expression to one in reverse polish notation.
	 * Assume order of operation is always explicitly specified by brackets.
	 * ie. (a+b+c) is no valid, must be ((a+b)+c) or (a+(b+c))
	 * @param in
	 * @return
	 */
	public static String toReversePolish(String in) {
		// store the operands and operator at each priority level according to bracketing
		ArrayList<List<StringBuffer>> operands = new ArrayList<List<StringBuffer>>();
		ArrayList<List<String>> operators = new ArrayList<List<String>>();
		operands.add(new ArrayList<StringBuffer>());
		operators.add(new ArrayList<String>());
		operands.ensureCapacity(in.length());
		operators.ensureCapacity(in.length());
		
		int lvl = 0;
		// read each character in arithmetic expression from left to right. Assume no whitespace.
		for (char c : in.toCharArray()) {
			if (c == '(') {
				lvl++; 
				try {
					operands.get(lvl);
					operands.get(lvl).add(new StringBuffer());
				} catch (IndexOutOfBoundsException e) {
					operands.add(new ArrayList<StringBuffer>());
					operators.add(new ArrayList<String>());
					operands.get(lvl).add(new StringBuffer());
				}
				continue;
			} else if (c <=122 & c >=97) {
				// lower case ascii letters
				int last = operands.get(lvl).size()-1;
				operands.get(lvl).get(last).append(c);
			} else if (c == ')') {
				lvl--;
				continue;
			} else {
				// operators
				operators.get(lvl).add(String.valueOf(c));
			}
		}
		StringBuffer out = new StringBuffer();
		for (int i = operands.size() - 1; i >=0; i--) {
			for (int j = 0; j < operands.get(i).size(); j++) {
				out.append(operands.get(i).get(j).toString());
				out.append(operators.get(i).get(j));
			}
		}
		
		return out.toString();
	}
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int cases = sc.nextInt();
//		while (cases > 0) {
//			String exp = sc.nextLine();
//			System.out.println(toReversePolish(exp));
//		}
		System.out.println(toReversePolish("(a+((b-c)/d))"));
		System.out.println(toReversePolish("(a+(b*c))"));
		System.out.println(toReversePolish("((a+b)*(z+x))"));
		System.out.println(toReversePolish("((a+t)*((b+(a+c))^(c+d)))"));
	}
}
