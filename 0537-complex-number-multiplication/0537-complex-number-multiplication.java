class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] number1 = new int[2];
        int[] number2 = new int[2];
        number1 = parse(num1);
        number2 = parse(num2);

        StringBuilder answer = new StringBuilder();

        answer.append(Integer.toString(number1[0] * number2[0] - number1[1] * number2[1]));
        answer.append("+");
        answer.append(Integer.toString(number1[0] * number2[1] + number1[1] * number2[0]));
        answer.append("i");

        return answer.toString();
    }

    private int[] parse(String num) {
        String[] nums = num.split("\\+");
        
        int[] parseNums = new int[2];
        parseNums[0] = Integer.parseInt(nums[0]);
        parseNums[1] = Integer.parseInt(nums[1].substring(0, nums[1].length() - 1));

        return parseNums;
    }
}