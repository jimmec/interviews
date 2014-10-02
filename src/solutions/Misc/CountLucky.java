package solutions.Misc;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * HackerRank 
 * https://www.hackerrank.com/challenges/count-luck
 * 
 * DFS solution
 * @author jimmy
 */
public class CountLucky {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            // read the test case
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] board = new char[n][m];
            for (int j = 0; j < n; j++) {
                String line = sc.next();
                board[j] = line.toCharArray();
            }
            int K = sc.nextInt();
            
            // solve this board
            //printBoard(board);
            int k = solveBoard(board);
            if (k == K) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        }
    }
    
    private static int solveBoard(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        // find M
        int i = 0;
        while (board[i/m][i%m] != 'M') {
            i++;
        }
        int x = i%m;
        int y = i/m;
        
        Deque<State> stack = new LinkedList<State>();
        stack.addFirst(new State(x,y,0));
        
        while (stack.size() > 0) {
            State st = stack.removeFirst();
            int xx = st.x;
            int yy = st.y;
            int ww = st.wandWaves;
            if (board[yy][xx] == '*') {
                return ww;
            }
            int choices = checkLeft(xx,yy,board) + checkRight(xx,yy,board) + checkUp(xx,yy,board) + checkDown(xx,yy,board);
            if (choices > 1) {
                addNextSteps(xx,yy,ww+1,stack,board);
            } else if (choices == 1) {
                addNextSteps(xx,yy,ww,stack,board);
            }
            // Mark spot as visited
            board[yy][xx] = 'X';
            //printBoard(board);
        }
        return -1;
        
    }
    private static void addNextSteps(int xx, int yy, int newWaves, Deque<State> stack, char[][] board) {
        if (checkLeft(xx,yy,board) > 0) {
            stack.addFirst(new State(xx-1,yy,newWaves));
        }
        if (checkRight(xx,yy,board) > 0) {
            stack.addFirst(new State(xx+1,yy,newWaves));
        }
        if (checkUp(xx,yy,board) > 0) {
            stack.addFirst(new State(xx,yy-1,newWaves));
        }
        if (checkDown(xx,yy,board) > 0) {
            stack.addFirst(new State(xx,yy+1,newWaves));
        }
    }
    public static class State {
        final int x;
        final int y;
        final int wandWaves;
        
        public State(int x, int y, int ww) {
            this.x = x;
            this.y = y;
            this.wandWaves = ww;
        }
    }
    private static int checkLeft(int x, int y, char[][] b) {
        if (x == 0) {
            return 0;
        } else if (b[y][x-1] != 'X' ) {
            return 1;
        } else {
            return 0;
        }
    }
    private static int checkRight(int x, int y, char[][] b) {
        if (x == b[0].length-1) {
            return 0;
        } else if (b[y][x+1] != 'X' ) {
            return 1;
        } else {
            return 0;
        }
    }    
    private static int checkUp(int x, int y, char[][] b) {
        if (y == 0) {
            return 0;
        } else if (b[y-1][x] != 'X' ) {
            return 1;
        } else {
            return 0;
        }
    }    
    private static int checkDown(int x, int y, char[][] b) {
        if (y == b.length-1) {
            return 0;
        } else if (b[y+1][x] != 'X' ) {
            return 1;
        } else {
            return 0;
        }
    }
    private static void printBoard(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }
}

