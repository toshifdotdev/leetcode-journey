// Problem: Reverse Pairs (#493)
// Date: 07-07-2026

// Approach 1 (Brute Force)
//
// Check every possible pair (i, j)
// where i < j and count if:
//
// nums[i] > 2 * nums[j]
//
// Time Complexity : O(n²)
// Space Complexity: O(1)


// Approach 2 (Optimal - Merge Sort)

// arr[i] > 2 * arr[j]
//
// Overall Complexity:
//
// Time Complexity : O(2n log n)
// Space Complexity: O(n)

class Solution {

    // -------------------------------------------------
    // Merge two sorted halves
    // -------------------------------------------------
    private void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    // Imp:
    // Use long to avoid integer overflow while
    // calculating 2 * arr[right].
    private int countPairs(int[] arr, int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high &&
                    (long) arr[i] > 2L * arr[right]) {

                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    // Merge Sort
    private int mergeSort(int[] arr, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(arr, low, mid);

        count += mergeSort(arr, mid + 1, high);

        // Count reverse pairs across halves
        count += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);

        return count;
    }

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }
}