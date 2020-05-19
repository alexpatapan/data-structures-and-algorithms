/**
Leetcode 209 - Minimum Size Subarray Sum
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while (endIndex < nums.length) {
            
            sum += nums[endIndex];
            
            while (startIndex <= endIndex && sum - nums[startIndex] >= s) {
                sum -= nums[startIndex];
                startIndex++;
            }
            
            if (sum >= s) minLen = Math.min(minLen, endIndex - startIndex);
            
            endIndex++;
        }
        
        if (minLen != Integer.MAX_VALUE) {
            return minLen+1;
        }
        return 0;
    }
}
