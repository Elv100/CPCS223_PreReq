import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SummingDigits {
    public static void main (String[]args){
        StdOut.println("Find the sum of digits for:");
        int num = StdIn.readInt();
        StdOut.println(sumOfDigits(num));
    }

    public static int sumOfDigits (int n){
        if (n == 0){
            return 0;
        }
        else {
            return n%10 + sumOfDigits(n/10);
        }

    }

}
