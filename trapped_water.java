public class trapped_water {
    public static void main(String args[]){
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        
        //trapped water = (water level - height of bar) * width of bar
        //water level = min(leftmax boundary , rightmax boundary)
        
        //calculating left max boundary
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];
        for(int i=1; i<height.length; i++){
            leftmax[i] = Math.max(height[i],leftmax[i-1]);
        }

        // Calculating right max boundary
        int rightmax[] = new int[height.length];
        rightmax[height.length-1] = height[height.length-1];
        for(int i=height.length - 2; i>=0; i--){
            rightmax[i] = Math.max(height[i] , rightmax[i+1]);
        }

        int trappedwater = 0;
        int width = 2;
        for(int i=0; i<height.length; i++){
            int waterlevel = Math.min(leftmax[i],rightmax[i]);
            trappedwater += (waterlevel - height[i]) * width;
        }

        System.out.println("Total amount of water trapped between the bar : "+trappedwater);
    }
}
