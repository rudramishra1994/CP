class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] A,B;
        if(nums1.length > nums2.length){
            A = nums1;
            B = nums2;
        }else{
            A=nums2;B=nums1;
        }
        int m = A.length;
        int n = B.length;
        int total = m+n;
        int half = (m+n)/2;    
        int l = 0 , r = n-1; double val = 0.0d;
        while(true){
            int Bmid  = (int) (Math.floor((1.0*(r+l)/2)));
            int Amid  = half - Bmid -2;

            int Bleft = Bmid >=0?B[Bmid]:Integer.MIN_VALUE;
            int Aleft = Amid >=0?A[Amid]:Integer.MIN_VALUE;
            int Bright = Bmid+1 <=n-1 ? B[Bmid+1] : Integer.MAX_VALUE;
            int Aright = Amid+1 <=m-1 ? A[Amid+1] : Integer.MAX_VALUE;
            if(Bleft <=Aright && Aleft<=Bright){
                if(total%2 ==0){
                    val = Math.min(Aright,Bright) + Math.max(Aleft,Bleft);
                    val = val/2;
                }else val = Math.min(Aright,Bright);
                return val;
            }else if(Bleft > Aright) {
                r = Bmid - 1;
            }else l = Bmid + 1;   

        }

    }
}