import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int[][] grid;
    // Make the DP array class static so we cache previous work
    private static int[][] waitTimes;
    private static int lastX = Integer.MAX_VALUE;
    private static int lastY = Integer.MAX_VALUE;
    public static void main(String args[] ) throws Exception {
        // Read inputs
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        grid = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Read starting coords and solve
        int numCases = sc.nextInt();
        waitTimes = new int[M][N];
        for (int i = 0; i < numCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(minWait(x,y));
        }
    }

    private static int minWait(int x, int y) {
        int M = grid.length;
        int N = grid[0].length;
        if (x >= lastX && y >= lastY) {
            return cachedMinWait(x,y);
        }
        // initialize the M by N array needed for DP
        waitTimes[M-1][N-1] = grid[M-1][N-1];
        for (int i = waitTimes.length - 2; i >= 0 ; i--) {
            waitTimes[i][N-1] = waitTimes[i+1][N-1] + grid[i][N-1];
        }
        for (int j = waitTimes[0].length - 2; j >= 0; j--) {
            waitTimes[M-1][j] = waitTimes[M-1][j+1] + grid[M-1][j];
        }

        // fill table according to DP recursion relation
        for ( int i = waitTimes.length-2; i >= x; i--) {
            for(int j = waitTimes[0].length-2; j >= y; j--) {
                waitTimes[i][j] = grid[i][j] + Math.min(waitTimes[i+1][j], waitTimes[i][j+1]);
            }
        }
        lastX = x + 1;
        lastY = y + 1;

        return waitTimes[x][y];
    }

    private static int cachedMinWait(int x, int y) {
        if (waitTimes[x][y] > 0) {
            return waitTimes[x][y];
        }
        // fill table according to DP recursion relation
        for ( int i = lastX; i >= x; i--) {
            for(int j = lastY; j >= y; j--) {
                waitTimes[i][j] = grid[i][j] + Math.min(waitTimes[i+1][j], waitTimes[i][j+1]);
            }
        }

        // Save the last processed
        lastX = x + 1;
        lastY = y + 1;

        return waitTimes[x][y];
    }
}