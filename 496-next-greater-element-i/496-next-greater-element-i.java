class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = nums2.length - 1; index >= 0; index--) {
            while (!st.isEmpty()) {
                if (st.peek() > nums2[index]) {
                    map.put(nums2[index], st.peek());
                    break;
                } else {
                    st.pop();
                }
            }
            st.push(nums2[index]);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                nums1[i] = map.get(nums1[i]);
            } else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}