import java.util.*;
public class Trapping_RainWater{
    public static int trappedRainWater(int nums[]){
        // trapped water = (water level - bar level height) * width of bar;
        //water level = min(leftMaxBoundary,rightMaxBoundary);

        //Calculate left max boundary
        int leftMax[] = new int[nums.length];
        leftMax[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            leftMax[i] = Math.max(nums[i],leftMax[i-1]);
        }

        //Calculate Right max boundary
        int rightMax[] = new int[nums.length];
        rightMax[nums.length -1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            rightMax[i] = Math.max(nums[i],rightMax[i+1]);
        }
        int trappedwater = 0;
        int width = 1;

        for(int i=0; i<nums.length; i++){
            int waterlevel = Math.min(leftMax[i],rightMax[i]);
            trappedwater += (waterlevel - nums[i]) * width;
        }
        return trappedwater;
    }
    public static void main(String args[]){
        int height[] = {4,2,0,6,3,2,5};
        System.out.println("Total amount of water trapped between the bar : "+trappedRainWater(height));
    }
}
