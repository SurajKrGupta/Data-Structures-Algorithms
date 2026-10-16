class Solution {
    public void rev(int s,int e,int[] nums){
        while(s<e){
            int t=nums[s];
            nums[s]=nums[e];
            nums[e]=t;
            s++;
            e--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        
        rev(0,nums.length-1,nums);
        rev(0,k-1,nums);
        rev(k,nums.length-1,nums);
        
    }
}