class SmallestInfiniteSet {    
    private final int MAX_NUM = 1000;
    private boolean[] infiniteSet;
    private int minNum;
    
    public SmallestInfiniteSet() {
        infiniteSet = new boolean[1001];
        Arrays.fill(infiniteSet, true);
        minNum = 1;
    }
    
    public int popSmallest() {
        infiniteSet[minNum] = false;
        int smallestNum = minNum;
        
        while (minNum <= MAX_NUM && infiniteSet[minNum] == false) {
            minNum++;
        }
        
        return smallestNum;
    }
    
    public void addBack(int num) {
        if (infiniteSet[num] == false) {
            infiniteSet[num] = true;
            minNum = Math.min(minNum, num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */