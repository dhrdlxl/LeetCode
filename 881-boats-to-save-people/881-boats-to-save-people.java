class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        Arrays.sort(people);
        
        while (left <= right) {
            int minNum = people[left];
            int maxNum = people[right];
            
            if (people[left] + people[right] <= limit) {
                left++;
            }
            
            right--;
            answer++;
        }
        
        return answer; 
    }
}