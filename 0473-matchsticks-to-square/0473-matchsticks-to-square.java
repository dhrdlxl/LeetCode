class Solution {
    private int[] direction;
    private int sum;
    public boolean makesquare(int[] matchsticks) {
        direction = new int[4];
        for (int stick : matchsticks) {
            sum += stick;
        }
        
        if (matchsticks.length < 4 || sum % 4 != 0) {
            return false;
        }
        
        Arrays.sort(matchsticks);
        
        return simulation(matchsticks.length - 1, matchsticks);
    }
    
    private boolean simulation(int step, int[] matchsticks) {
        boolean answer = false;
        int n = matchsticks.length;
        if (step < 0) {
            answer = true;
            for (int i = 0; i < 4; i++) {
                if (direction[i] != sum / 4) {
                    answer = false;
                    break;
                }
            }
            
            return answer;
        }
        
        for (int i = 0; i < 4; i++) {
            if (direction[i] + matchsticks[step] <= sum / 4) {
                direction[i] += matchsticks[step];
                if (simulation(step - 1, matchsticks) == true) {
                    return true;
                }
                direction[i] -= matchsticks[step];
            }
        }
        
        return answer;
    }
}