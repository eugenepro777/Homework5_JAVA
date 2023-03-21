package Homework5;

public class Task4 {

    /* На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.*/

    public static void main(String[] args) {
        int[] queens = new int[8];
        findFreePosition(queens, 0);
        printBoard(queens);
    }

    public static void printBoard(int[] queen) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (queen[row] == column) {
                    System.out.print("♛\t");
                } else {
                    System.out.print("░\t");
                }
            }
            System.out.println();
        }
    }

    private static boolean findFreePosition(int[] queen, int row) {
        if (row == 8) return true;
        for (int column = 0; column < 8; column++) {
            boolean flag = true;
            for (int i = 0; i < row; i++) {
                if (queen[i] == column || queen[i] == column - row + i || queen[i] == column + row - i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                queen[row] = column;
                if (findFreePosition(queen, row + 1)) return true;
            }
        }
        return false;
    }

}
