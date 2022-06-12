class FreqStack {
    HashMap<Integer, Integer> map;
    List<List<Integer>> freqList;
    
    public FreqStack() {
        map = new HashMap<>();
        freqList = new LinkedList<>();
    }
    
    public void push(int val) {
        if (!map.containsKey(val)) {
            map.put(val, 0);
        }
        int count = map.get(val) + 1;
        map.put(val, count);
        
        if (freqList.size() < count) {
            freqList.add(new LinkedList<>());
        }
        freqList.get(count - 1).add(val);
    }
    
    public int pop() {
        int maxIndex = freqList.size() - 1;
        int recentIndex = freqList.get(maxIndex).size() - 1;
        
        int val = freqList.get(maxIndex).get(recentIndex);
        
        freqList.get(maxIndex).remove(recentIndex);
        if (freqList.get(maxIndex).size() == 0) {
            freqList.remove(maxIndex);
        }
        
        map.put(val, map.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */