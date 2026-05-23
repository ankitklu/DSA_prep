class Solution {
    public long minOperations(int[] nums) {
        long cost = 0, req = 0;

        for (int i = 1; i < nums.length; i++) {
            long prev = nums[i - 1] + req;

            if (nums[i] + req < prev) {
                long need = prev - (nums[i] + req);
                req += need;
                cost += need;
            }
        }

        return cost;
    }
}
// 2, 5, 1, 3
// 2, 5, 5, 5 -> 4

// 2, 1, 5, 3
// 2, 2, 5, 5
