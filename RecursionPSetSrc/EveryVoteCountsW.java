import java.util.ArrayList;
import java.util.Arrays;

public class EveryVoteCountsW {

    public static ArrayList<ArrayList<Integer>> global = new ArrayList<ArrayList<Integer>>();
    public static int count = 0;

    public static void main(String[] args) {

        ArrayList<Integer> empty = new ArrayList<Integer>();
        global.add(empty);
        ArrayList<Integer> full_list = new ArrayList<Integer>(Arrays.asList(4,2,7,4));

        System.out.println("full_list: " + full_list.toString());

    countCriticalVotes(full_list, full_list.size() - 1, 3);
        System.out.println(global.toString());
        System.out.println(count);
}

    private static void countCriticalVotes(ArrayList<Integer> full_list, int index, int blocksIndex){
        int check = full_list.remove(blocksIndex);
        subset(full_list, index-1, check);
    }
    private static void subset(ArrayList<Integer> full_list, int index, int check) {
        int fullCount = 0;
        for (Integer count: full_list) {
             fullCount += count;
        }
        if (index < 0) return;
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        //copy list
        for (ArrayList<Integer> sub : global) {
            ArrayList<Integer> sub_temp = new ArrayList<Integer>();
            sub_temp.add(full_list.get(index));
            //add old list
            for (Integer integer : sub) {
                sub_temp.add(integer);
                int subCount = 0;
                for (Integer subs: sub_temp) {
                    subCount += subs;
                }
                if (Math.abs((subCount - (fullCount - subCount))) <= check){
                    count++;
                }
            }
            temp.add(sub_temp);
        }
        global.addAll(temp);
        subset(full_list, index - 1, check);
    }

}
