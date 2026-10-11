```java
/**
 * Problem: Divide Intervals Into Minimum Number of Groups (#2406)
 * Date: 11-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy + Line Sweep
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N log N) - sorting 2N events
 *
 * Space Complexity:
 * O(N) - storing 2N events
 * ------------------------------------------------------------
 */

class Pair {
    int time;
    char state;

    Pair(int time, char state) {
        this.time = time;
        this.state = state;
    }
}

class Solution {
    public int minGroups(int[][] intervals) {
        // Optimal 
        int n = intervals.length;

        List<Pair> li = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            li.add(new Pair(intervals[i][0], 'A'));
            li.add(new Pair(intervals[i][1], 'D'));
        }

        li.sort(Comparator.comparingInt((Pair p) -> p.time).thenComparingInt(p -> p.state));
        
        int cnt = 0;
        int maxiCnt = 0;

        for(int i = 0; i < li.size(); i++) {
            if(li.get(i).state == 'A') cnt++;
            else cnt--;
            maxiCnt = Math.max(maxiCnt, cnt);
        }

        return maxiCnt;

        // int maxiInter = 0;// maxi intersection = mini no. of interval
        // // arr[j] <= arr[i] && dep[j] >= arr[i]

        // for(int i = 0; i < intervals.length; i++) {
        //     int cnt = 0;
        //     for(int j = 0; j < intervals.length; j++) {
        //         if(intervals[j][0] <= intervals[i][0] && intervals[i][0] <= intervals[j][1]) {
        //             cnt++;
        //         }
        //     }
        //     maxiInter = Math.max(maxiInter, cnt);
        // }

        // return maxiInter; 
    }
}
```