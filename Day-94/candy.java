```java
/**
 * Problem: Candy (#135)
 * Date: 14-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy (Slope Approach)
 * ------------------------------------------------------------
 *
 * Traverse the ratings array and divide it into three patterns:
 *
 * 1. Flat Surface:
 *    When adjacent ratings are equal, each child needs at least
 *    one candy. Add one candy and move forward.
 *
 * 2. Increasing Slope:
 *    When ratings increase, each child must receive more candies
 *    than the previous child. Increase peak and add its value
 *    to the total sum.
 *
 * 3. Decreasing Slope:
 *    When ratings decrease, candies decrease along the slope.
 *    Track the decreasing slope using down and add the required
 *    candies to the total.
 *
 * Finally, compare down with peak. If the decreasing slope is
 * longer than the increasing slope, the peak needs additional
 * candies to satisfy both neighboring children.
 *
 * Observation:
 * The peak child must have more candies than both neighboring
 * children. The correction (down - peak) handles this when the
 * decreasing slope is longer than the increasing slope.
 *
 * Example:
 * ratings = [1, 0, 2]
 *
 * Required candies = [2, 1, 2]
 *
 * Total candies = 5
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each rating is processed a constant number of times
 *
 * Space Complexity:
 * O(1) - only a few variables are used
 * ------------------------------------------------------------
 */

class Solution {
    public int candy(int[] ratings) {
        int i = 1;
        int sum = 1;
        int n = ratings.length;

        while(i < n) {
            // flat-surface
            // if or while -> if adding if continue ayega
            while(i < n && ratings[i] == ratings[i-1]) {
                sum+=1;
                i++;
                // continue;
            }

            // increase-slope 
            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]) {
                peak++;
                sum+=peak;
                i++;
            }

            // decrease-slope
            int down = 1;
            while(i < n && ratings[i] < ratings[i-1]) {
                sum+=down;
                down++;
                i++;
            }

            // sort out the maxi 
            if(down > peak) {
                sum = sum + (down - peak); // remaining sum 
            }
        }

        return sum;
    }

    // Brute-Force
    // int n = ratings.length;
    // if(n == 1) return 1;
    // int[] left = new int[n];
    // int[] right = new int[n];
    //
    // left[0] = 1; right[n-1] = 1;
    //
    // for(int i = 1; i <= n-1; i++) {
    //     if(ratings[i] > ratings[i-1]) {
    //         left[i] = left[i-1] + 1;
    //     }
    //     else {
    //         left[i] = 1;
    //     }
    // }
    //
    // for(int i = n - 2; i >= 0; i--) {
    //     if(ratings[i] > ratings[i+1]) {
    //         right[i] = right[i+1] + 1;
    //     }
    //     else {
    //         right[i] = 1;
    //     }
    // }
    //
    // // finding maxi
    //
    // int sum = 0;
    //
    // for(int i = 0; i < n; i++) {
    //     sum+= Math.max(left[i], right[i]);
    // }
    //
    // return sum;
}
```