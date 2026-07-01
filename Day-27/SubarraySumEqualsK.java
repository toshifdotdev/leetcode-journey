// Problem: Subarray Sum Equals K (#560)
// Date: 02-07-2026

// ----------------------------------------------------
// Approach 1 (Better)
// ----------------------------------------------------
//
// Generate every possible subarray and calculate
// its sum.
//
// If the sum equals k, increase the count.
//
// Time Complexity : O(n²)
// Space Complexity: O(1)


// ----------------------------------------------------
// Approach 2 (Optimal - Prefix Sum + HashMap)
// ----------------------------------------------------

// Time Complexity : O(n) Average
// Space Complexity: O(n)

class Solution {

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int preSum = 0;

        // <Prefix Sum, Frequency>
        HashMap<Integer, Integer> hm = new HashMap<>();

    
        hm.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            preSum += nums[i];
            int rem = preSum - k;
            count += hm.getOrDefault(rem, 0);
            hm.put(preSum, hm.getOrDefault(preSum, 0) + 1);
        }

        return count;


        /*
        ----------------------------------------------------
        Better Approach
        ----------------------------------------------------

        int count = 0;

        for(int i = 0; i < nums.length; i++) {

            long sum = 0;

            for(int j = i; j < nums.length; j++) {

                sum += nums[j];

                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
        */
    }
}