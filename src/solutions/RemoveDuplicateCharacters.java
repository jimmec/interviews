package solutions;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 03/09/14
 * Time: 2:31 PM
 * Removes duplicate characters in a string
 */
public class RemoveDuplicateCharacters {
    public static String dedupeASCIIString(String in) {
        // Assuming ASCIII char set, and there are less than MAX_INT number of repeats for each character
        int[] charMap = new int[256];
        for (char aChar : in.toCharArray()) {
            charMap[aChar] += 1;
        }

        // Get number of unique character for final output length
        int len = 0;
        for (int count : charMap) {
            if (count > 0) {
                len += 1;
            }
        }

        if (len == 0) {
            return "";
        }

        char[] out = new char[len];
        int i = 0;
        for (char aChar : in.toCharArray()) {
            if (charMap[aChar] > 0) {
                out[i] = aChar;
                i++;
                charMap[aChar] = -1; // flip the charMap to exclude future appearances of this character
            }
        }
        return new String(out);
    }

    public static void main (String[] args) {
        System.out.println(dedupeASCIIString("aabbcd"));
        System.out.println(dedupeASCIIString("abcd"));
        System.out.println(dedupeASCIIString(""));
        System.out.println(dedupeASCIIString("aaaaaaaa"));
        System.out.println(dedupeASCIIString("aaaaazzzzz_____"));
    }
}
