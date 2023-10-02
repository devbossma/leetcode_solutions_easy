package easy;

import java.util.*;



public class Soluutions {
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
    public static String sortSentence(String s) {
        //          "is2 sentence4 This1 a3"
        StringBuilder resl = new StringBuilder();
        List<String> splited = Arrays.asList(s.split(" "));
        SortedMap<Integer, String> sorted = new TreeMap<>();

        for (int i = 0; i < splited.size(); i++) {
            String x = splited.get(i);
            int d = (int) x.charAt(x.length()-1);
            sorted.put(d,x);
        }
//     or
        /*splited.forEach(x->{
            int d = (int) x.charAt(x.length()-1);
            sorted.put(d,x);
        });*/


        sorted.forEach((k,v)-> {
            resl.append(v.substring(0,v.length()-1)+" ");


        });

        return (resl.toString()).trim();
    }
    public static String sortedSentence(String s){
        String[] splited = s.split(" ");
        String[] sorted = new String[splited.length];
        StringBuilder result = new StringBuilder();
        for(int i=0; i<splited.length; i++){
            int index = splited[i].charAt(splited[i].length()-1)-'0';
            sorted[index-1] = splited[i].substring(0,splited[i].length()-1);
        }

        for(int i=0; i<sorted.length; i++){

            result.append(sorted[i]).append(" ");
        }
        System.out.println(Arrays.asList(sorted));
        return result.toString().trim();
    }
    public static boolean  reNumbersAscending(String s) {
//
        String regular_expression = "^(\\d+)";
        String[] splited = s.split(" ");
        int count = 0;
        int prev=0;

        for (int i = 0; i < splited.length ; i++) {
            if (splited[i].matches(regular_expression)) {
                int d = Integer.parseInt(splited[i]);
                if (d <= prev) {
                    count++;
                }
                prev = d;
            }
        }
        return count == 0;
    }
}