
import hard.Solutions;

import java.util.*;

import static hard.Solutions.largestRectangleArea;


public class Main {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        int max = largestRectangleArea(heights);
        System.out.println("**** max: ["+max+"] ****");
    }
}
