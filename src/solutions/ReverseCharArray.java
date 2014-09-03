package solutions;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 03/09/14
 * Time: 2:17 PM
 * Reverse a C-style string, ie. the string "abcd" is represented as 5 characters with a null character terminating it.
 */
public class ReverseCharArray {
    public static char[] reverseCStyle(char[] input) {
        int len = input.length;
        char[] output = new char[len];
        // start at the second to last character
        for (int i = len-2, j = 0; i >= 0; i--, j++) {
            output[j] = input[i];
        }
        output[len-1] = 0;

        return output;
    }

    public static void main(String[] args) {
        System.out.println(new String(ReverseCharArray.reverseCStyle("abcd\0".toCharArray())));
    }
}
