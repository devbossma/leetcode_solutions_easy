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
        Stack<Integer> index = new Stack<>();
        Stack<Integer> rect = new Stack<>();


        for (int i = 0; i < heights.length; i++) {
            int tempMax;
            if (i == 0 ) {
                index.push(i);
                rect.push(heights[i]);
                tempMax = rect.peek();
                if (tempMax > max) max = tempMax;
            }else{
                if (heights[i] < heights[i-1]){

                    int lastIndex=0;

                    while(!rect.isEmpty() && (heights[i] < rect.peek())){
                        lastIndex = index.pop();
                        int lastRect = rect.pop();
                        tempMax = lastRect * (i - lastIndex);

                        if (tempMax > max) max = tempMax;
                        tempMax = 0;

                    }
                    rect.push(heights[i]);
                    index.push(lastIndex);

                }else if(heights[i] > heights[i-1]){
                    rect.push(heights[i]);
                    index.push(i);
                }
            }
        }
        System.out.println(rect.size());
        System.out.println(index);
        System.out.println(rect);
        while(rect.size() > 0){
            int tempMax = 0;
            int rectVal = rect.pop();
            tempMax = rectVal*(heights.length-index.pop());
            if (tempMax > max) max = tempMax;
        }


        System.out.println(index);
        System.out.println(rect);
        return max;
    }





}

