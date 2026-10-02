/**
 * Problem: Insert Interval (#57)
 * Date: 02-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Three-Part Interval Processing
 * ------------------------------------------------------------
 *
 * Divide the intervals into three parts:
 *
 * 1. Left Part:
 *    Add all intervals that end before the new interval starts.
 *    These intervals do not overlap with the new interval.
 *
 * 2. Overlapping Part:
 *    Merge all intervals that overlap with the new interval.
 *    Update the start with the minimum start and the end with
 *    the maximum end.
 *
 * 3. Right Part:
 *    Add all remaining intervals after the merged interval.
 *
 * Finally, convert the ArrayList into a 2D array.
 *
 * Observation:
 * Since the intervals are already sorted by starting time,
 * we can process them from left to right in a single pass.
 *
 * Example:
 * intervals = [[1,3], [6,9]]
 * newInterval = [2,5]
 *
 * [1,3] overlaps with [2,5], so they become [1,5].
 * [6,9] is added afterwards.
 *
 * Result:
 * [[1,5], [6,9]]
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N)
 *
 * Space Complexity:
 * O(N) - result list
 * ------------------------------------------------------------
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        // left part find
        int i = 0;

        while(i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // overlapping

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        // left over right part add

        while(i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}