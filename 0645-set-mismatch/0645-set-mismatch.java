class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        boolean[] check = new boolean[10001];

        for (int num : nums) {
            if (check[num]) {
                answer[0] = num;
            }
            check[num] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (check[i] == false) {
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}