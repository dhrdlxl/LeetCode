class Solution {
    public int maxChunksToSorted(int[] arr) {
        int answer = 0;
        int n = arr.length;
        int[] sortedArray = Arrays.copyOf(arr, n);
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(sortedArray);
        for (int i = 0; i < n; i++) {
            map.put(sortedArray[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            int left = arr[i];
            int rightIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (left > arr[j]) {
                    rightIndex = j;
                }
            }
            
            for (int j = i + 1; j <= rightIndex; j++) {
                rightIndex = Math.max(rightIndex, map.get(arr[j]));
            }
            
            i = rightIndex;
            
            answer++;
        }
        
        return answer;
    }
}