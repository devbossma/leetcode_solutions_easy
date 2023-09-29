import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i = 0; i < operations.length; i++){
            if (operations[i].equals("++X")) ++x;
            if (operations[i].equals("X++")) x++;
            if (operations[i].equals("--X")) --x;
            if (operations[i].equals("X--")) x--;
        }
        /*for (String op:operations
             ) {
            if (op.equals("++X")) ++x;
            if (op.equals("X++")) x++;
            if (op.equals("--X")) --x;
            if (op.equals("X--")) x--;
        }*/
        return x;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i ) {
                    l.add(1);
                }else {
                    l.add(j, ((finalList.get(i-1)).get(j-1) + (finalList.get(i-1)).get(j)));
                }

            }
            finalList.add(l);


        }
        return finalList;
    }
}