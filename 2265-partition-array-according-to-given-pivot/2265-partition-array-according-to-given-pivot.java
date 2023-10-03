class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        int equal = 0;
        for(int item : nums){
            if(item < pivot)less.add(item);
            else if(item > pivot)more.add(item);
            else equal++;
        }

        int [] ans = new int [nums.length];
        int i = 0;
        for(int item : less) ans[i++] = item;
        while(equal-- > 0) ans[i++] = pivot;
        for(int item : more) ans[i++] = item;

        return ans;
    }
}