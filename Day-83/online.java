/**
 * Problem: Online Stock Span (LeetCode #901)
 * Date: 21-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Monotonic Stack - Previous Greater Element
 * ------------------------------------------------------------
 *
 * Brute-Force:
 * Time Complexity: O(n) per next() call
 *
 * Optimal:
 * Time Complexity: O(n) amortized
 *
 * Every price is pushed once and popped at most once.
 *
 * Space Complexity:
 * O(n)
 *
 * ------------------------------------------------------------
 */

// ------------------------------------------------------------
// Brute-Force
// ------------------------------------------------------------

// class StockSpanner {
//     List<Integer> li;

//     public StockSpanner() {
//         li = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         li.add(price);
//         int cnt = 1;

//         for(int i = li.size()-2; i>=0; i--) {
//             if(price >= li.get(i)) cnt++;
//             else break;
//         }
//         return cnt;
//     }
// }


// ------------------------------------------------------------
// Optimal
// ------------------------------------------------------------

class Pair {
    int indi;
    int price;

    Pair(int price, int indi) {
        this.price = price;
        this.indi = indi;
    }
}

class StockSpanner {
    Stack<Pair> st;
    int index;

    // Previous Greater Element

    public StockSpanner() {
        st = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index++;

        // Remove all previous prices that are smaller than
        // or equal to the current price.
        while(!st.isEmpty() && price >= st.peek().price) {
            st.pop();
        }

        // The stack top is the nearest Previous Greater Element.
        int conseDays = index - (st.isEmpty() ? -1 : st.peek().indi);

        // Store current price and its index.
        st.push(new Pair(price, index));

        return conseDays;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */