import java.util.Random;

class RandomizedSet {
    private HashSet<Integer> set;
    
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        Random rand = new Random();
        int random = rand.nextInt(set.size());
        int i = 0;
        
        for (Object obj : set) {
            if (i == random) {
                return (int)obj;
            }
            i++;
        }
        
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */