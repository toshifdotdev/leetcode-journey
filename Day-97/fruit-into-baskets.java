/**
 * Problem: Fruit Into Baskets (#904)
 * Date: 26-10-2026
 *
 * ------------------------------------------------------------
 * Approach: Sliding Window + HashMap
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N) - each pointer moves forward at most N times.
 *
 * Space Complexity:
 * O(1) - the HashMap stores at most three fruit types
 *         temporarily.
 * ------------------------------------------------------------
 */

class Solution {
    public int totalFruit(int[] fruits) {
        // Optimal

        int n = fruits.length;

        int l = 0, r = 0, maxiLen = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        while(r < n) {
            hm.put(fruits[r], hm.getOrDefault(fruits[r], 0) + 1);

            if(hm.size() > 2) {
                hm.put(fruits[l], hm.get(fruits[l]) - 1);
                if(hm.get(fruits[l]) == 0) hm.remove(fruits[l]);
                l++;
            }

            maxiLen = Math.max(maxiLen, r - l + 1);

            r++;

        }
        return maxiLen;

        // Better
        // int n = fruits.length;

        // int l = 0, r = 0, maxiLen = 0;
        // HashMap<Integer, Integer> hm = new HashMap<>();

        // while(r < n) {
        //     hm.put(fruits[r], hm.getOrDefault(fruits[r], 0) + 1);

        //     while(hm.size() > 2) {
        //         hm.put(fruits[l], hm.get(fruits[l]) - 1);
        //         if(hm.get(fruits[l]) == 0) hm.remove(fruits[l]);
        //         l++;
        //     }

        //     maxiLen = Math.max(maxiLen, r - l + 1);

        //     r++;

        // }
        // return maxiLen;

        // Brute - Force
        // int n = fruits.length;
        // if(n <= 2) return n;
        // int maxiCnt = 0;

        // for(int i = 0; i < n; i++) {
        //     int cnt = 0;
        //     Set<Integer> set = new HashSet<>();
        //     for(int j = i; j < n; j++) {
        //         set.add(fruits[j]);
        //         if(set.size() == 3) break;
        //         cnt++;
        //     }
        //     maxiCnt = Math.max(maxiCnt, cnt);
        // }

        // return maxiCnt;
    }
}
