/**
 * Problem: Fractional Knapsack
 * Date: 24-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Greedy
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(N log N) - sorting the items
 *
 * Space Complexity:
 * O(N) - storing the items
 * ------------------------------------------------------------
 */

class Item {
    int value;
    int weight;
    
    public Item(int v, int w) {
        value = v;
        weight = w;
    }
}

class MyComp implements Comparator<Item> {
    
    public int compare(Item a, Item b) {
        double rat2 = (double)b.value / b.weight;
        double rat1 = (double)a.value / a.weight;
        
        return Double.compare(rat2, rat1);
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        Item arr[] = new Item[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = new Item(val[i], wt[i]);
        }
        
        Arrays.sort(arr, new MyComp());
        
        double totalVal = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i].weight <= capacity) {
                capacity -= arr[i].weight;
                totalVal += arr[i].value;
            }
            else {
                totalVal += arr[i].value / (double)arr[i].weight * capacity;
                break;
            }
        }
        
        return totalVal;
    }
}