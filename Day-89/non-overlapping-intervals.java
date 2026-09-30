/**
 * Problem: Non-overlapping Intervals (#435)
 * Date: 30-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy
 * ------------------------------------------------------------
 *
 * Sort the intervals according to their ending time.
 *
 * The interval that finishes earliest leaves the maximum amount
 * of space for the remaining intervals.
 *
 * We keep track of:
 * - cnt: Number of non-overlapping intervals we can keep.
 * - freeTime: Ending time of the last selected interval.
 *
 * If the starting time of the current interval is greater than
 * or equal to freeTime, the interval does not overlap, so we keep
 * it and update freeTime.
 *
 * Finally:
 *
 * Number of intervals to remove =
 * Total intervals - Number of intervals we can keep.
 *
 * Observation:
 * This is the same greedy idea used in Activity Selection:
 * always choose the interval that finishes earliest.
 *
 * Example:
 * intervals = [[1,2], [2,3], [1,3]]
 *
 * After sorting by end time:
 * [1,2], [2,3], [1,3]
 *
 * Keep [1,2] and [2,3].
 * Remove [1,3].
 *
 * Answer = 3 - 2 = 1
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N log N) - sorting the intervals
 *
 * Space Complexity:
 * O(1) auxiliary space (excluding sorting space)
 * ------------------------------------------------------------
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int n = intervals.length;
        int cnt = 1;
        int freeTime = intervals[0][1];

        for(int i = 1; i < n; i++) {
            if(intervals[i][0] >= freeTime) {
                cnt++;
                freeTime = intervals[i][1];
            }
        }

        return n-cnt;
    }
}