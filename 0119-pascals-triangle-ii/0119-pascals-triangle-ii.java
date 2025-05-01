class Solution {
    public List<Integer> getRow(int rowIndex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        for (int i = 0; i < rowIndex; i++) {
            q.add(q.peek());

            for (int j = 0; j + 1 <= i; j++) {
                q.add(q.remove() + q.peek());
            }
            
            q.add(q.remove());
        }

        return new ArrayList<>(q);
    }
}