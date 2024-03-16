class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(items1, (a, b) -> a[0] - b[0]);
        Arrays.sort(items2, (a, b) -> a[0] - b[0]);
        
        int index = 0;
        for (int[] item1 : items1) {
            while (index < items2.length && items2[index][0] < item1[0]) {
                answer.add(Arrays.asList(items2[index][0], items2[index][1]));
                index++;
            }
            
            if (index < items2.length && item1[0] == items2[index][0]) {
                answer.add(Arrays.asList(item1[0], item1[1] + items2[index][1]));
                index++;
            } else {
                answer.add(Arrays.asList(item1[0], item1[1]));
            }
        }
        
        while (index < items2.length) {
            answer.add(Arrays.asList(items2[index][0], items2[index][1]));
            index++;
        }
        
        return answer;
    }
}