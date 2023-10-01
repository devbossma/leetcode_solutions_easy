import java.util.*;

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
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[nums.length + i] = nums[i];
        }

        return ans;
    }
    public static int countPalindromicSubsequence(String s) {
        //

        Set<String> Palindrom = new HashSet<>();
        Set<Character> right = new HashSet<>();
        Map<Character,Integer> left = new HashMap<>();
        right.add(s.charAt(0));


        for (int i = 1; i < s.length(); i++) {
            if (left.containsKey(s.charAt(i))){
                left.put(s.charAt(i),left.get(s.charAt(i))+1);

            }else {
                left.put(s.charAt(i),1);
            }

        }

        for (int i = 1; i < s.length()-1; i++) {
            char mid = s.charAt(i);
            right.forEach( (x) -> {
                if(left.containsKey(x)) {
                    if(!((x == mid ) && (left.get(mid) == 1))){
                        Palindrom.add(""+x+mid+x);
                    }
                }
            });

            right.add(mid);
            if (left.get(mid) > 1) {
                left.put(mid, left.get(mid)-1);
            }else left.remove(mid);
        }

        return Palindrom.size();
    }
}