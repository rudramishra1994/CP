class Leetcode1137 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        else if (n<3) return 1;
        int tn_2 = 1 ;
        int tn_1 = 1;
        int tn_0 = 0;
        for(int i = 3; i <= n;i++){
            int k = tn_2 + tn_1 + tn_0;
            tn_0 = tn_1;
            tn_1 = tn_2;
            tn_2 = k;
        }
        return tn_2;
    }
}