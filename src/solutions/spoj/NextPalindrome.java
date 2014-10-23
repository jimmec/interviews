package solutions.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextPalindrome {
	public static void main(String[] args) throws IOException {
//		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//		int cases = Integer.parseInt(r.readLine());
//		
//		while (cases > 0) {
//			String in = r.readLine();
//			System.out.println(np(in));
//			cases--;
//		}
		System.out.println(np("9999999999999999999999999999999999"));
	}

	private static String np(String in) {
		// convert decimal string into a array of digits
		byte[] digits = new byte[in.length()];
		for (int i = 0; i < in.length(); i++) {
			digits[i] = (byte) (in.charAt(i)-48);
		}

		boolean isOddLen = (in.length() % 2) == 1;
		int midLeft = in.length()/2 -1;
		int midRight = isOddLen ? in.length()/2+1 : in.length()/2;
		int left = midLeft; int right = midRight;
		// check each digit starting in the middle
		while (left >= 0 && right < in.length()) {
			if (digits[left] > digits[right]) {
				return makePalin(digits, 0, midLeft);
			} else if (digits[left] < digits[right]) {
				if (isOddLen) {
					addOneWithCarryOver(in.length()/2, digits);
					// dont need to worry about 9999... case since left < right
					return makePalin(digits, 0, midLeft);
				} else {
					addOneWithCarryOver(midLeft, digits);
					return makePalin(digits, 0, midLeft);
				}
			} else {
				left--; right++;
			}
		}
		
		// if we make it this far, it means input was a palindrome
		if (isOddLen) {
			addOneWithCarryOver(in.length()/2, digits);
		} else {
			addOneWithCarryOver(midLeft, digits);
		}
		
		if (digits[0] == 0) { // input looked like ...999...
			return makePalin(digits, 0, midLeft, 1);
		} else {
			return makePalin(digits, 0, midLeft);
		}
	}

	private static void addOneWithCarryOver(int start, byte[] digits) {
		int mid = start;
		do { // add 1 with carry over
			digits[mid] = (byte) ((digits[mid] + 1) % 10); 
			mid--;
		} while (mid >= 0 && digits[mid+1]==0);
	}

	private static String makePalin(byte[] digits, int start, int midLeft, int...first) {
		// if first[0] is passed, we need to behave as tho digits is first+digits
		StringBuilder sb = new StringBuilder();
		if (first.length == 1) {
			// build palindrome with first d[start]...d[midLeft] (d[mid]) d[midLeft]...d[start] first
			sb.append(first[0]);
			if ((digits.length % 2) == 0) {
				midLeft--;
			}
			for (int i = start; i <= midLeft; i++) {
				sb.append(digits[i]);
			}
			
			if ((digits.length + 1 )% 2 == 1) {
				sb.append(digits[digits.length/2 - 1]);
			}
			
			for (int i = midLeft; i > 0; i--) {
				sb.append(digits[i]);
			} 
			
			if (midLeft >= 0) {
				sb.append(digits[0]);
			}
			sb.append(first[0]);
		} else if (first.length == 0){
			// build palindrome with d[start]...d[midLeft] (d[mid]) d[midLeft]...d[start]
			for (int i = start; i <= midLeft; i++) {
				sb.append(digits[i]);
			}
			
			if (digits.length % 2 == 1) {
				sb.append(digits[digits.length/2]);
			}
			
			for (int i = midLeft; i > 0; i--) {
				sb.append(digits[i]);
			} 
			
			if (midLeft >= 0) {
				sb.append(digits[0]);
			}
		}
		
		return sb.toString();
	}

	public static boolean isPalin(String in) {
		StringBuilder sb = new StringBuilder(in);
		return sb.equals(sb.reverse());
	}
}
