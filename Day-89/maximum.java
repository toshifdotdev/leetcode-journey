/**
 * Problem: Maximum Meetings
 * Date: 30-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy
 * ------------------------------------------------------------
 * Example:
 * Start = [1, 3, 0, 5, 8, 5]
 * End   = [2, 4, 6, 7, 9, 9]
 *
 * Meetings are sorted by ending time and selected greedily.
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N log N) - sorting the meetings
 *
 * Space Complexity:
 * O(N) - storing the meeting objects and answer
 * ------------------------------------------------------------
 */

class meet {
    int st, end, pos;
    
    meet(int a, int b, int c) {
        st = a;
        end = b;
        pos = c;
    }
}

class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        int n = s.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        meet[] arr = new meet[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new meet(s[i], f[i], i+1);
        }
        
        // sort 
        Arrays.sort(arr, (a,b) -> Integer.compare(a.end, b.end));
        
        int freeTime = arr[0].end;
        ans.add(arr[0].pos);
        
        for(int i = 1; i < n; i++) {
            if(arr[i].st > freeTime) {
                freeTime = arr[i].end;
                ans.add(arr[i].pos);
            }
        }
        
        return ans;
    }
}