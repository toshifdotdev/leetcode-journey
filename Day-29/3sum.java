// Problem: 3Sum (#15)
// Date: 04-07-2026

// ------------------------------------------------------------
// Approach 2 (Better - HashSet)
// ------------------------------------------------------------

//
// Time Complexity : O(n² * log3) ≈ O(n²)
// Space Complexity: O(n²)


// ------------------------------------------------------------
// Approach 2 (Optimal - Sorting + Two Pointers)
// ------------------------------------------------------------
//
// Time Complexity : O(n²)
// Space Complexity: O(1) (excluding output list)

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        // ----------------------------
        // Optimal Approach
        // ----------------------------

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Sorting enables the two-pointer technique
        Arrays.sort(nums);

        // Fix the first element of the triplet
        for (int i = 0; i < n; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {

                    j++;

                } else if (sum > 0) {

                    k--;

                } else {

                    // Valid triplet found
                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    ans.add(temp);

                    j++;
                    k--;

                    // Skip duplicate second elements
                    while (j < k && nums[j] == nums[j - 1])
                        j++;

                    // Skip duplicate third elements
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        return ans;





        // -------------------------------------------------
        // Better Approach (HashSet)
        // -------------------------------------------------

        /*
        Set<List<Integer>> set = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            Set<Integer> possible = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int third = -(nums[i] + nums[j]);

                if (possible.contains(third)) {

                    List<Integer> triplet = new ArrayList<>();

                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(third);

                    // Sort so duplicate triplets
                    // have identical ordering
                    Collections.sort(triplet);

                    set.add(triplet);
                }

                possible.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
        */
    }
}