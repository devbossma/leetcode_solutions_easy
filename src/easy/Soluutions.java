package easy;

import hard.Solutions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Soluutions {
    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i = 0; i < operations.length; i++){
            if (operations[i].equals("++X")) ++x;
            if (operations[i].equals("X++")) x++;
            if (operations[i].equals("--X")) --x;
            if (operations[i].equals("X--")) x--;
        }
        
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
    // 1859. Sorting the Sentence(version 1)
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



        sorted.forEach((k,v)-> {
            resl.append(v.substring(0,v.length()-1)+" ");


        });

        return (resl.toString()).trim();
    }
    //1859. Sorting the Sentence (version 2 )
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
    //2042. Check if Numbers Are Ascending in a Sentence
    public static boolean  areNumbersAscending(String s) {

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
    //2460. Apply Operations to an Array
    public static int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        int counter=0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if(nums[i] != 0) ans[counter++] = nums[i];
        }
        return ans;
    }

    //26. Remove Duplicates from Sorted Array
    public static int  removeDuplicates(int[] nums) {
        List<Integer> helper = new ArrayList<>();
        int k=0;
        if (nums.length > 1){
            for (int i = 0; i < nums.length-1; i++) {
                if ((nums[i] == nums[i+1]) && !helper.contains(nums[i])){
                    helper.add(nums[i]);
                    if(!helper.contains(nums[i+1])){
                        helper.add(nums[i+1]);
                    }
                } else if (nums[i] != nums[i+1]) {
                    if (!helper.contains(nums[i])){
                        helper.add(nums[i]);
                    }
                    if(!helper.contains(nums[i+1])){
                        helper.add(nums[i+1]);
                    }
                }
            }
            for (int i = 0; i < helper.size(); i++) {
                nums[i] = helper.get(i);
            }
            k = helper.size();
        }else if (nums.length == 1){
            helper.add(nums[0]);
            k = helper.size();
        }else k = helper.size();
        return k;
    }
    // 27. Remove Element
    public static int removeElement(int[] nums, int val) {
        List<Integer> notValue = new ArrayList<>();
        int k =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                notValue.add(nums[i]);
                k = notValue.size();}
        }
        for (int i = 0; i < notValue.size(); i++) {
            nums[i] = notValue.get(i);
        }
        return k;
    }
    // 832. Flipping an Image
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] flipped = new int[n][n];
        int bit;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][(n-1)-j] == 0){
                    bit = 1;
                    flipped[i][j] = bit;
                }else if (image[i][(n-1)-j] == 1){
                    bit =0;
                    flipped[i][j] = bit;
                }
            }
        }
        return flipped;
    }


    //***************  872. Leaf-Similar Trees *******************//
    // treeNode class definition;
    public static class TreeNode {
      int val;
      public  TreeNode left;
      public  TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public static  List<List<Integer>> rTolist(List<List<Integer>> list, TreeNode n){
        List<Integer> r = new ArrayList<>();
        if(n.left == null  && n.right == null){
            r.add(n.val);
            list.add(r);
        }
        if(n.left != null){rTolist(list, n.left);}
        if (n.right != null){ rTolist(list, n.right); }
        return list;
    }
    public static  boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<List<Integer>> leaf1 = new ArrayList<>();
        List<List<Integer>> leaf2 = new ArrayList<>();
        List<List<Integer>> r1 = rTolist(leaf1, root1);
        List<List<Integer>> r2 = rTolist(leaf2, root2);
        boolean similar = r1.size() == r1.size();
        if(r1.size() != r2.size()) similar = false;
        if(!r1.equals(r2)) similar = false;


        return similar;
    }
   // 136. Single Number
    public static int singleNumber(int[] nums) {
        List<Integer> single = new ArrayList<>();
        List<Integer> doubled = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i == 0)
                single.add(nums[0]);
            else{
                if (single.contains(nums[i])){
                    single.remove(single.indexOf(nums[i]));
                    doubled.add(nums[i]);
                }else single.add(nums[i]);
            }
        }
        return single.get(0);

    }
    // 1920. Build Array from Permutation
    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i <= nums.length-1; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
    // 1512. Number of Good Pairs
    public static int numIdenticalPairs(int[] nums) {
        int count=0;
        Map<Integer,Integer> helper = new HashMap<>();
        Map<Integer,Integer> helper2 = new HashMap<>();
        Stack<Integer> itemsInNums = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (helper.containsKey(nums[i])){
                int prev = helper.get(nums[i]);
                int innerCount = helper2.get(nums[i]);
                innerCount = (prev*prev) - innerCount;

                helper.put(nums[i], helper.get(nums[i])+1);
                helper2.put(nums[i], innerCount);

            }
            if (!helper.containsKey(nums[i])){

                helper.put(nums[i], 1);
                helper2.put(nums[i], 0);
            }
            if (!itemsInNums.contains(nums[i])) itemsInNums.push(nums[i]);
        }

        while (!itemsInNums.isEmpty()){
            count = count + helper2.get(itemsInNums.pop());
        }

        return count;
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        Queue<Integer> indexes = new LinkedList<>();
        Queue<Integer> indexesOfn = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            indexes.add(nums[i]);
        }
        for (int i = n; i < nums.length; i++) {
            indexesOfn.add(nums[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            if(((i+1)%2) == 0){
                ans[i]= indexesOfn.peek();
                indexesOfn.remove();
            }else {
                ans[i] = indexes.peek();
                indexes.remove();
            }
        }

        return ans;
    }
}
