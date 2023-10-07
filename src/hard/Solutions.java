package hard;

import easy.Soluutions;

import java.util.*;

public class Solutions {
    // 42. Trapping Rain Water
    public static int trap(int[] height) {
        int trapped = 0;
        int currentElevation = 0;
        int maxElevation = 0;
        int secondMaxElevation = 0;
        int indexOfMaxElevation = 0;
        int indexOfSecondElevation = 0;

        List lHeight = new ArrayList<>();


        while (currentElevation < height.length){
            if (height[currentElevation] >= maxElevation) {
                maxElevation = height[currentElevation];
                indexOfMaxElevation = currentElevation;
            }
            lHeight.add(height[currentElevation]);
            currentElevation++;
        }
        for (int i = 0; i < height.length; i++) {
            if(height[i] <= maxElevation && height[i] > secondMaxElevation){
                secondMaxElevation = height[i];
                indexOfSecondElevation = i;
            }
        }
        int curentMaxElevation=0;
        for (int i = 0; i < height.length-1; i++) {
            if((i < indexOfSecondElevation && i < indexOfMaxElevation)){
                if (height[i] > curentMaxElevation) curentMaxElevation = height[i];
                trapped += curentMaxElevation - height[i];
            }
            if (i > indexOfSecondElevation && i < indexOfMaxElevation) {
                trapped += secondMaxElevation - height[i];
            }
            if (i > indexOfMaxElevation){
                curentMaxElevation = height[i];
                for (int j = i; j < height.length; j++) {
                    if (height[j] > curentMaxElevation) curentMaxElevation = height[j];
                }
                trapped += curentMaxElevation - height[i];
            }
        }
        return trapped;
    }
    // 84. Largest Rectangle in Histogram
    public static int largestRectangleArea(int[] heights) {
        int max=0;
        List<Integer> maxOfIndex = new ArrayList<>();
        for (int i = 1; i < heights.length; i++) {



        }
        System.out.println(maxOfIndex);





        return max;
    }






}

