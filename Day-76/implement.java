/**
 * Problem: Implement Stack using Queues (#225)
 * Date: 10-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Using a Single Queue
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * push() -> O(n)
 * pop()  -> O(1)
 * top()  -> O(1)
 * empty() -> O(1)
 *
 * Space Complexity: O(n)
 * ------------------------------------------------------------
 */

class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int size = q.size();

        q.add(x);
        for(int i = 0; i < size; i++) {
            q.add(q.peek());
            q.poll();
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 *
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */