import edu.princeton.cs.algs4.StdOut;

public class CoinGame {
    private static int counter;

    public static void main(String[] args) {
        int num = 30;
        go(30, true);

        if (num % 3 == 0)
            StdOut.println("Picker 2 wins with " + counter + " ways");
        else
            StdOut.println("Picker 1 wins with " + counter + " ways");
    }

    public static void go(int n, boolean current_picker) {
        if (n >= 0) {
            if (n == 0)
                counter++;
            else {
                if ((n - 1) % 3 == 0) {
                    go(n - 1, !current_picker);
                    go(n - 4, !current_picker);
                } else if ((n - 2) % 3 == 0) {
                    go(n - 2, !current_picker);
                } else {
                    go(n - 1, !current_picker);
                    go(n - 2, !current_picker);
                    go(n - 4, !current_picker);
                }
            }
        }
    }
}