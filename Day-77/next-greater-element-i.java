/**
 * Problem: Next Greater Element I (#496)
 * Date: 13-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Monotonic Stack + HashMap
 * ------------------------------------------------------------

 * Example:
 *
 * nums2 = [1, 3, 4, 2]
 *
 * Next greater elements:
 *
 * 1 -> 3
 * 3 -> 4
 * 4 -> -1
 * 2 -> -1
 *
 * HashMap:
 * {1=3, 3=4, 4=-1, 2=-1}
 *
 * If nums1 = [4, 1, 2]
 *
 * Answer = [-1, 3, -1]
 *
 * ------------------------------------------------------------
 *
 * Observation:
 *
 * The stack is maintained in decreasing order from bottom
 * to top while traversing from right to left.
 *
 * Elements that cannot be the next greater element are removed
 * permanently because they are smaller than or equal to the
 * current element and will never be useful for this position.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity: O(nums1.length + nums2.length)
 * Space Complexity: O(nums2.length)
 * ------------------------------------------------------------
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Optimal: Monotonic Stack + HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Traverse nums2 from right to left
        for(int i = nums2.length - 1; i >= 0; i--) {

            // Remove elements that cannot be the next greater
            // element for nums2[i]
            while(!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }

            // Top of stack is the next greater element
            if(st.isEmpty()) {
                hm.put(nums2[i], -1);
            }
            else {
                hm.put(nums2[i], st.peek());
            }

            // Current element becomes a candidate for elements
            // to its left
            st.push(nums2[i]);
        }

        // Build answer for nums1 using the HashMap
        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }

        return ans;


        // ----------------------------------------------------
        // Brute Force
        // ----------------------------------------------------

        // int[] arr = new int[nums1.length];
        //
        // for(int i = 0; i < nums1.length; i++) {
        //     int elem = nums1[i];
        //     boolean found = false;
        //
        //     for(int j = 0; j < nums2.length; j++) {
        //
        //         if(elem == nums2[j]) {
        //             found = true;
        //         }
        //
        //         if(found && elem < nums2[j]) {
        //             arr[i] = nums2[j];
        //             break;
        //         }
        //     }
        //
        //     if(arr[i] == 0) arr[i] = -1;
        // }
        //
        // return arr;
    }
}