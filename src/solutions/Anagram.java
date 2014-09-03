package solutions;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 03/09/14
 * Time: 2:58 PM
 * Determines if 2 strings are anagrams
 */
public class Anagram {
    public static boolean isASCIIAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charMap1 = new int[256];
        int[] charMap2 = new int[256];
        int len = str1.length();
        for (int i = 0; i< len; i++) {
            charMap1[str1.charAt(i)] += 1;
            charMap2[str2.charAt(i)] += 1;
        }

        // now check if they have the exact same characters
        for (int i = 0; i < 256; i++) {
            if (charMap1[i] != charMap2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main (String[] args) {
        // Test cases
        String s1 = "a bc";
        String s2 = "cb a";
        System.out.println(String.format("%s and %s are anagrams: %s", s1, s2, isASCIIAnagram(s1,s2)));

        String s3 = "ccc";
        String s4 = "a";
        System.out.println(String.format("%s and %s are anagrams: %s", s3, s4, isASCIIAnagram(s3,s4)));

        String s5 = "a";
        String s6 = "b";
        System.out.println(String.format("%s and %s are anagrams: %s", s5, s6, isASCIIAnagram(s5,s6)));

        String s7 = "";
        String s8 = "cba";
        System.out.println(String.format("%s and %s are anagrams: %s", s7, s8, isASCIIAnagram(s7,s8)));

        String s9 = "";
        String s10 = "";
        System.out.println(String.format("%s and %s are anagrams: %s", s9, s10, isASCIIAnagram(s9,s10)));
    }
}
