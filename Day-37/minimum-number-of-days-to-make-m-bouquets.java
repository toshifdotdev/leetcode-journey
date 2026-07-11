// Problem: Minimum Number of Days to Make m Bouquets (#1482)
// Date: 12-07-2026

// Approach (Optimal - Binary Search on Answer)


// Time Complexity : O(n × log(MaxBloomDay - MIN +1))
// Space Complexity: O(1)


class Solution {
    // Possible 
    // day -- which day are we talking about 
    private boolean possible(int[] arr, int day ,int m, int k) {
        int cnt = 0;
        long noOfB = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= day) {
                cnt++;
            }
            else {
                noOfB += (long)(cnt/k);
                cnt = 0;
            }
        }
        noOfB += (long)(cnt/k);
        if(noOfB >= m) return true;
        else return false;
    }


    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long val = (long)(m) * k;
        if(val > n) return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();  //min
        int high = Arrays.stream(bloomDay).max().getAsInt(); // max

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(!possible(bloomDay, mid, m, k)) {
                low = mid+1;  
            }
            else {
                high = mid - 1;
            }
        }
      return low;
        
    }
}