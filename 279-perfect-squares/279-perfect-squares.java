import java.util.*;

class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int num = 1; num * num <= n; num++) {
            arr.add(num * num);
        }
        
        
        int[] dp = new int[n + 1];
        
        for (int num = 1; num <= n; num++) {
            int minCost = 10001;
            
            for (int index = 0; index < arr.size(); index++) {
                int psNum = arr.get(index); // perfect square number
                
                if (num == psNum) {
                    minCost = 1;
                    break;
                } else if (num - psNum > 0) {
                    minCost = min(minCost, dp[num - psNum] + 1);
                } else {
                    break;
                }
            }
            
            dp[num] = minCost;
        }
        
        return dp[n];
    }
    
    public int min(int a, int b) {
        return a < b ? a : b;
    }
}