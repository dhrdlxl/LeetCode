class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> answer = new ArrayList<>();
        int left = nums[0];
        int right = nums[0];


        for (int i = 1; i < nums.length; i++) {
            if (right + 1 == nums[i]) {
                right = nums[i];
            } else {
                addAnswer(left, right, answer);
                left = nums[i];
                right = nums[i];
            }
        }

        addAnswer(left, right, answer);        

        return answer;
    }

    private void addAnswer(int left, int right, List<String> answer) {
        if (left == right) {
            answer.add(String.valueOf(left));
        } else {
            answer.add(String.valueOf(left) + "->" + String.valueOf(right));
        }
    }
}