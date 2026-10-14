class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int h=m+n-1;
        while(n>0 && h>=0){
            if(m>0 && nums1[m-1]>nums2[n-1]){
                nums1[h]=nums1[m-1];
                --m;
            }else{
                nums1[h]=nums2[n-1];
                --n;
            }
            --h;
        }
    }
}