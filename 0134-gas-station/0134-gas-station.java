class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i < n;i++){
            totalGas += gas[i];
            totalCost+= cost[i];
        }
        if(totalGas < totalCost) return -1;

        int tank = 0;
        int start = 0;
        for(int i = 0 ; i < n ;i++){
            tank += gas[i] - cost[i];
    
            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }

        return tank < 0 ? -1 : start;


    }
}