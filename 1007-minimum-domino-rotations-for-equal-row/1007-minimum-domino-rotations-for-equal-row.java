class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //1. 전체 (top, bottom 이 같은 수일 경우 1개 더함)
        int[] wholeCount = new int[7];
        //2. top
        int[] topCount = new int[7];
        //3. bottom
        int[] bottomCount = new int[7];
        
        for (int i = 0; i < tops.length; i++) {
            int top = tops[i];
            int bottom = bottoms[i];
            
            if (top == bottom) {
                wholeCount[top]++;
            } else {
                topCount[top]++;
                bottomCount[bottom]++;
                
                wholeCount[top]++;
                wholeCount[bottom]++;
            }
        }
        
        int min = tops.length;
        
        for (int i = 1; i <= 6; i++) {
            if (wholeCount[i] == tops.length) {
                int tempMin = Math.min(topCount[i], bottomCount[i]);
                min = Math.min(min, tempMin);
            }
        }
        
        return min == tops.length ? -1 : min;
    }
}