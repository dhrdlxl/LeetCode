class Solution {
    private final int ONE_DAY = 60 * 24;
    
    public int findMinDifference(List<String> timePoints) {
        int answer = ONE_DAY;
        List<Integer> times = new ArrayList<>();

        for (String timePoint : timePoints) {
            String[] time = timePoint.split(":");
            times.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        
        times.sort((a, b) -> a - b);
        
        for (int i = 1; i < times.size(); i++) {
            int timeDiff = times.get(i) - times.get(i - 1) ;
            answer = Math.min(answer, Math.min(timeDiff, ONE_DAY - timeDiff));
        }
        
        if (times.size() > 1) {
            answer = Math.min(answer, ONE_DAY - (times.get(times.size() - 1) - times.get(0)));
        }
        
        return answer;
    }
}
