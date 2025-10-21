class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == totalSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}

//Time complexity = O(n)
