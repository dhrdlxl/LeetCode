class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        set.add(0);
        q.add(0);
        
        while (!q.isEmpty()) {
            int cur = q.remove();
            
            for (int next: rooms.get(cur)) {
                if (!set.contains(next)) {
                    set.add(next);
                    q.add(next);
                }
            }
        }
        
        return set.size() == rooms.size() ? true : false;
    }
}