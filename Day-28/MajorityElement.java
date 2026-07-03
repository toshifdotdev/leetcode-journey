// Problem: Majority Element II (#229)
// Date: 03-07-2026

// ----------------------------------------------------
// Approach 1 (Brute Force)
// ----------------------------------------------------
// Time Complexity : O(n²)
// Space Complexity: O(1)


// ----------------------------------------------------
// Approach 2 (Better - HashMap)
// ----------------------------------------------------

// Time Complexity : O(n)
// Space Complexity: O(n)


// ----------------------------------------------------
// Approach 3 (Optimal - Moore's Voting Algorithm)
// ----------------------------------------------------
//
// Time Complexity : O(n)
// Space Complexity: O(1)

class Solution {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        int cnt1 = 0;
        int cnt2 = 0;

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

      
        for (int i = 0; i < n; i++) {

            if (cnt1 == 0 && nums[i] != el2) {

                cnt1 = 1;
                el1 = nums[i];
            }

            else if (cnt2 == 0 && nums[i] != el1) {

                cnt2 = 1;
                el2 = nums[i];
            }

            else if (nums[i] == el1) {

                cnt1++;
            }

            else if (nums[i] == el2) {

                cnt2++;
            }

            else {

                // Cancel out different elements.
                cnt1--;
                cnt2--;
            }
        }

        // ---------------------------------------
        //  Verify both candidates
        // ---------------------------------------
        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {

            if (num == el1) cnt1++;

            if (num == el2) cnt2++;
        }

        int minimumFrequency = (n / 3) + 1;

        if (cnt1 >= minimumFrequency) {

            ans.add(el1);
        }

        if (cnt2 >= minimumFrequency) {

            ans.add(el2);
        }

        return ans;


        /*
        ----------------------------------------------------
        Better Approach (HashMap)
        ----------------------------------------------------

        HashMap<Integer, Integer> hm = new HashMap<>();

        int minLimit = (n / 3) + 1;

        for (int num : nums) {

            hm.put(num, hm.getOrDefault(num, 0) + 1);

            if (hm.get(num) == minLimit) {

                ans.add(num);
            }

            if (ans.size() == 2) break;
        }

        return ans;
        */


        /*
        ----------------------------------------------------
        Brute Force
        ----------------------------------------------------

        for(int i = 0; i < n; i++) {

            if(ans.size() == 0 || !ans.contains(nums[i])) {

                int count = 0;

                for(int j = 0; j < n; j++) {

                    if(nums[i] == nums[j]) {

                        count++;
                    }
                }

                if(count > (n/3)) {

                    ans.add(nums[i]);
                }
            }

            if(ans.size() == 2) break;
        }

        return ans;
        */
    }
}