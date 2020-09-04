import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class EveryVoteCounts {
    public static void main(String[] args) {
        ArrayList<Integer> blocks = new ArrayList<Integer>(Arrays.asList(4,2,7,4));
        int blockIndex = 3;
        StdOut.println(CountCriticalVotes(blocks,blockIndex));

    }
    public static int CountCriticalVotes(ArrayList<Integer> blocks, int blockIndex){
        int critNum = 0;
        int fullSum = 0;
        for (int elem: blocks){
            fullSum += elem;
        }
        int rm = blocks.remove(blockIndex);
        //do for Num of PowerSets
        for (int i = 0; i < Math.pow(2,blocks.size()); i++){
            int subSetSum = 0;
            for (int j = 0; j < blocks.size(); j++){
                /*bit wise comparison--Checks i as a binary number,
                1<<j means 1000 with j many 0s
                if (1<<j) goes thru each digit, if digits 1, then adds from arrayList[j] to current sum*/
                if ((i & (1<<j)) > 0){
                    subSetSum += blocks.get(j);
                }
            }
            if (Math.abs((subSetSum - (fullSum-subSetSum))) <= rm){
                critNum++;
            }
        }
        return critNum;
    }

}
