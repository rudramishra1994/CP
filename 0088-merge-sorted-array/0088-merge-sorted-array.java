class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right2 = nums2.length - 1;
        int right1 = m-1;
        int currPos = nums1.length - 1;

        while(currPos >=0 && right2 >=0 && right1 >=0){
            if(right2 >=0 && right1>=0 && nums1[right1] < nums2[right2]){
                nums1[currPos--] = nums2[right2];
                right2--;
            }
            if (right1 >=0 && right2>=0 && nums1[right1] >= nums2[right2]){
                nums1[currPos--] = nums1[right1];
                right1--;
            } 
        }
        while(right2 >=0)
            nums1[currPos--] = nums2[right2--];

    }
}