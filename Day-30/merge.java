// Problem: Merge Intervals (#56)
// Date: 05-07-2026

// ----------------------------------------------------
// Approach 1 (Brute Force)
// ----------------------------------------------------
//
// Time Complexity : O(n²)
// Space Complexity: O(n)


// ----------------------------------------------------
// Approach 2 (Optimal)
// ----------------------------------------------------
//
// Time Complexity : O(n log n)
// Space Complexity: O(n)

class Solution {

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        // ------------------------------------------
        // Sort by starting point.
        // If starting points are equal,
        // sort by ending point.
        // ------------------------------------------
        Arrays.sort(intervals, (a, b) ->
                a[0] == b[0]
                        ? Integer.compare(a[1], b[1])
                        : Integer.compare(a[0], b[0])
        );

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            // If answer is empty OR
            // current interval doesn't overlap,
            // simply add it.
            if (ans.isEmpty() ||
                    intervals[i][0] > ans.get(ans.size() - 1)[1]) {

                ans.add(intervals[i]);
            }

            // Otherwise merge with the previous interval.
            else {

                ans.get(ans.size() - 1)[1] =
                        Math.max(
                                ans.get(ans.size() - 1)[1],
                                intervals[i][1]
                        );
            }
        }

        // Convert List<int[]> to int[][]
        int[][] res = new int[ans.size()][];

        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}