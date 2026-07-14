// Problem: Split Array Largest Sum (#410)
// Date: 14-07-2026

// Approach (Optimal - Binary Search on Answer)

// Time Complexity:
// O(n × log(sum(nums) - max(nums)))
//
// Space Complexity:
// O(1)
// ------------------------------------------------------------

class Solution {

    // Returns the number of subarrays needed if each subarray
    // is allowed to have at most maxSum.
    private int countSubarrays(int[] arr, int maxSum) {
        int subarrays = 1;
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentSum + arr[i] <= maxSum) {
                // Add current element to the same subarray
                currentSum += arr[i];
            } else {
                // Start a new subarray
                subarrays++;
                currentSum = arr[i];
            }
        }

        return subarrays;
    }

    public int splitArray(int[] nums, int k) {

        // Minimum possible answer = largest element
        int low = Arrays.stream(nums).max().getAsInt();

        // Maximum possible answer = sum of all elements
        int high = Arrays.stream(nums).sum();

        // Binary Search on Answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Number of subarrays required with max allowed sum = mid
            int requiredSubarrays = countSubarrays(nums, mid);

            if (requiredSubarrays > k) {
                // Too many subarrays -> increase allowed sum
                low = mid + 1;
            } else {
                // Possible -> try smaller maximum sum
                high = mid - 1;
            }
        }

        return low;
    }
}