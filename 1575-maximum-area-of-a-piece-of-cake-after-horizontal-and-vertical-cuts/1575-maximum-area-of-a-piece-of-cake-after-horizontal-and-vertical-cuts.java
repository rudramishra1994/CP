class Solution {
    static int MOD = 1000000007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxHeight = 0;
        long maxWidth = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int prev = 0;
        for(int hCuts : horizontalCuts){
            maxWidth = maxWidth < hCuts-prev ? hCuts - prev : maxWidth;
            prev = hCuts;
        }
        maxWidth = maxWidth < h-prev ? h - prev : maxWidth;
        prev = 0;
        for(int vCuts : verticalCuts){
            maxHeight = maxHeight < vCuts - prev ? vCuts - prev : maxHeight;
            prev = vCuts;
        }
        maxHeight = maxHeight < w - prev ? w - prev : maxHeight;
        return (int) ((maxHeight * maxWidth) % MOD);
    }
}