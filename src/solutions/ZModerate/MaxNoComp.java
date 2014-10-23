package solutions.ZModerate;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 10/09/14
 * Time: 9:02 AM
 * Return the max of two integers without using a comparator or if..else
 */
public class MaxNoComp {
    public static int max(int a, int b) {
        int c = a-b;
        c = c >>> 31;
        return a-c*(a-b);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(String.format("%d, %d: max = %d",10,12,max(10,12)));
        System.out.println(String.format("%d, %d: max = %d",-2,-1,max(-2,-1)));
        System.out.println(String.format("%d, %d: max = %d",10,-10,max(10,-10)));
    }
}
