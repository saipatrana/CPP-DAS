class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=3;j++){
                int temp = i-j;
                if(temp>=0){
                    min=Math.min(min,dp[temp]+costs[i-1]+j*j);
                }
            }
            dp[i]=min;
        }
        return dp[n];
    }
}