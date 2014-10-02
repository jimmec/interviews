package solutions.ZModerate;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 11/09/14
 * Time: 12:07 AM
 * Takes a integer between 0 and 999999 and outputs the English phrase.
 */
public class NumberToEnglishPhrase {
    private static HashMap<Integer,String> digitToWord = new HashMap<Integer, String>();
    private static HashMap<Integer,String> teenMap = new HashMap<Integer, String>();
    private static HashMap<Integer,String> thousandMap = new HashMap<Integer, String>();
    private static HashMap<Integer,String> baseTenMap = new HashMap<Integer, String>();
    static {
        digitToWord.put(0, "");
        digitToWord.put(1, "one");
        digitToWord.put(2, "two");
        digitToWord.put(3, "three");
        digitToWord.put(4, "four");
        digitToWord.put(5, "five");
        digitToWord.put(6, "six");
        digitToWord.put(7, "seven");
        digitToWord.put(8, "eight");
        digitToWord.put(9, "nine");

        teenMap.put(2, "twenty");
        teenMap.put(3, "thirty");
        teenMap.put(4, "fourty");
        teenMap.put(5, "fifty");
        teenMap.put(6, "sixty");
        teenMap.put(7, "seventy");
        teenMap.put(8, "eighty");
        teenMap.put(9, "ninety");

        baseTenMap.put(2, "hundred");
        baseTenMap.put(3, "thousand");
        baseTenMap.put(4, "ten thousand");
        baseTenMap.put(5, "hundred thousand");
    }

    public static String toPhrase(Integer num) {
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        while (num > 0) {
            String phrase = parseHundreds(num);
            sb.insert(0, thousandMap.get(count));
            sb.insert(0,phrase);
            num = num / 1000;
            count++;
        }
        return sb.toString();
    }

    private static String parseHundreds(Integer num) {
        if (num > 99) {

        }
        return "";
    }

    public static void main(String[] args) {
        Integer num = 0;
        parseHundreds(num);
        System.out.println("4 asdf".split("\\s")[0]);
    }
}
