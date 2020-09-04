import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HumanPyramids {
    public static void main(String[] args) {
        StdOut.println("row:");
        int row = StdIn.readInt();
        StdOut.println("col:");
        int col = StdIn.readInt();
        double[][] mem = new double[row+1][row+1];
        StdOut.println("weight carry: " + weightOnBackOf(mem, row, col));
    }

    public static double weightOnBackOf(int row, int col) {
        int halfPerson = 100;
        if (row == 0 && col == 0) {
            return 0;
        } else if (col == 0) {
            return halfPerson + weightOnBackOf(row - 1, col) / 2;
        } else if (row == col) {
            return halfPerson + weightOnBackOf(row - 1, col - 1) / 2;
        } else {
            return halfPerson * 2 + weightOnBackOf(row - 1, col - 1) / 2 + weightOnBackOf(row - 1, col) / 2;
        }
    }

    public static double weightOnBackOf(double[][] mem, int row, int col) {
        int halfPerson = 100;
        //can simply do row+1, row+1 because no illegal inputs
        if (row == 0 && col == 0) {
            mem[0][0] = 0;
        } else if (mem[row][col] != 0) {
            return mem[row][col];
        }else if (col == 0) {
            mem[row][col] = halfPerson + weightOnBackOf(mem,row - 1, col) / 2;
        } else if (row == col) {
            mem[row][col] = halfPerson + weightOnBackOf(mem,row - 1, col - 1) / 2;
        } else {
            mem[row][col] = halfPerson * 2 + weightOnBackOf(mem,row - 1, col - 1) / 2 + weightOnBackOf(row - 1, col) / 2;
        }
        return mem[row][col];
    }
}



