// Problem: 4Sum (#18)
// Date: 04-07-2026

// ------------------------------------------------------------
// Approach 1 (Better - HashSet)
// ------------------------------------------------------------

// Time Complexity : O(n³)
// Space Complexity: O(n²)


// ------------------------------------------------------------
// Approach 2 (Optimal - Sorting + Two Pointers)
// ------------------------------------------------------------

//
// IMPORTANT:
//
// Use long while calculating the sum.
//
// Example:
//
// nums = [1000000000,1000000000,1000000000,1000000000]
//
// int sum would overflow.
// Therefore:
//
// long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
//
// Time Complexity : O(n³)
// Space Complexity: O(1) (excluding output)

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        // -----------------------------
        // Optimal Approach
        // -----------------------------

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {

                        List<Integer> temp = new ArrayList<>();

                        Collections.addAll(
                                temp,
                                nums[i],
                                nums[j],
                                nums[k],
                                nums[l]
                        );

                        ans.add(temp);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1])
                            k++;

                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }

                    else if (sum < target) {
                        k++;
                    }

                    else {
                        l--;
                    }
                }
            }
        }

        return ans;





        // --------------------------------------------------------
        // Better Approach (HashSet)
        // --------------------------------------------------------

        /*
        Set<List<Integer>> ans = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                Set<Long> seen = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    long sum = (long) nums[i] + nums[j] + nums[k];

                    long fourth = target - sum;

                    if (seen.contains(fourth)) {

                        List<Integer> temp = new ArrayList<>();

                        Collections.addAll(
                                temp,
                                nums[i],
                                nums[j],
                                nums[k],
                                (int) fourth
                        );

                        Collections.sort(temp);

                        ans.add(temp);
                    }

                    seen.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(ans);
        */
    }
}