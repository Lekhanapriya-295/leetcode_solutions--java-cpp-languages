class Solution {
    public int uniquePaths(int m, int n) {
        int minSize=Math.min(m,n);
        int maxSize=Math.max(m,n);
        int[] dp=new int[minSize];
        Arrays.fill(dp,1);
        for(int i=1;i<maxSize;i++){
            for(int j=1;j<minSize;j++){
                dp[j]+=dp[j-1];
            }
        }
        return dp[minSize-1];
    }
}