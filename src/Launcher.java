import solutions.ArraysAndStrings.ReverseCharArray;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 02/09/14
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {
    public static void main(String[] args) {
        System.out.println(new String(ReverseCharArray.reverseCStyle("abcd\0".toCharArray())));
    }
}
