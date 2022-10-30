class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        //1. binary search로 위치 찾기(under bound)
        int index = search(arr, x);
        
        //2. 양쪽으로 가까운 것 찾아나가기
        if (index >= arr.length) {
            index = arr.length - 1;
        }
        int left = index;
        int right = index;
        
        //2_1. 첫 위치 정하기(x랑 값이 다를 경우.)
        if (arr[index] != x) {
            if (index - 1 >= 0) {
                left = index - 1;
            }
            
            if (x - arr[left] <= arr[right] - x) {
                right = left;
            } else {
                left = right;
            }
        }
        
        //2_2. 범위 찾기
        while (right - left + 1 < k) {
            if (left - 1 < 0) {
                right++;
            }
            else if (right + 1 >= arr.length) {
                left--;
            }
            else if (x - arr[left - 1] <= arr[right + 1] - x) {
                left--;
            }
            else if (x - arr[left - 1] > arr[right + 1] - x) {
                right++;
            }
        }
        
        for (int i = left; i <= right; i++) {
            answer.add(arr[i]);
        }
        
        return answer;
    }
    
    private int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (target <= arr[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                result = mid + 1;
                left = mid + 1;
            }
        }
        
        return result;
    }
}