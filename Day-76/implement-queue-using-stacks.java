/**
 * Problem: Implement Queue using Stacks (#232)
 * Date: 10-09-2026
 *
 * ------------------------------------------------------------
 * Approach 1: Costly Push
 * ------------------------------------------------------------
 *
 * In this approach, push() takes O(n), while pop() and peek()
 * take O(1).
 *
 * The idea is to rearrange the elements after every push so
 * that the front of the queue is always available at the top
 * of st1.
 *
 * ------------------------------------------------------------
 *
 * Approach 2: Costly Pop/Peek (Used Below)
 * ------------------------------------------------------------
 *
 * We use two stacks:
 *
 *     st1 -> used for pushing new elements
 *     st2 -> used for popping/peeking in queue order
 *
 * push():
 * - Simply push the element into st1.
 *
 * pop()/peek():
 * - If st2 is not empty, use it directly.
 * - Otherwise, transfer all elements from st1 to st2.
 *
 * Reversing the elements while transferring makes the oldest
 * inserted element come to the top of st2.
 *
 * Therefore, st2 maintains the correct FIFO order.
 *
 * ------------------------------------------------------------
 *
 * Example:
 *
 * push(1) -> st1 = [1]
 * push(2) -> st1 = [1, 2]
 * push(3) -> st1 = [1, 2, 3]
 *
 * First pop:
 *
 * Transfer st1 -> st2
 *
 * st1 = []
 * st2 = [3, 2, 1]
 *
 * pop() -> 1
 * pop() -> 2
 * pop() -> 3
 *
 * This gives Queue behavior using two Stacks.
 *
 * ------------------------------------------------------------
 *
 * Complexity:
 *
 * push()  -> O(1)
 * pop()   -> O(1) amortized
 * peek()  -> O(1) amortized
 * empty() -> O(1)
 *
 * Space Complexity: O(n)
 *
 * ------------------------------------------------------------
 *
 * Note:
 * Although pop() or peek() can take O(n) in a single operation
 * when transferring elements, each element is transferred from
 * st1 to st2 only once before being removed. Hence the
 * amortized complexity of pop() and peek() is O(1).
 * ------------------------------------------------------------
 */

// Approach 1 : For More top, peek operation
// class MyQueue {
//     private Stack<Integer> st1;
//     private Stack<Integer> st2;
//
//     public MyQueue() {
//         st1 = new Stack<>();
//         st2 = new Stack<>();
//     }
//
//     public void push(int x) {
//         int sizeS1 = st1.size();
//         int sizeS2 = st2.size();
//
//         while(!st1.isEmpty()) {
//             st2.push(st1.peek());
//             st1.pop();
//         }
//
//         st1.push(x);
//
//         while(!st2.isEmpty()) {
//             st1.push(st2.peek());
//             st2.pop();
//         }
//     }
//
//     public int pop() {
//         return st1.pop();
//     }
//
//     public int peek() {
//         return st1.peek();
//     }
//
//     public boolean empty() {
//         return st1.isEmpty();
//     }
// }


// Approach 2 : For More Push
// Push is O(1), while pop/peek use the second stack when needed.

class MyQueue {
    private Stack<Integer> st1, st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if(!st2.isEmpty()) {
            return st2.pop();
        }
        else {
            while(st1.size() != 0) {  // or !st1.isEmpty()
                st2.push(st1.peek());
                st1.pop();
            }

            return st2.pop();
        }
    }

    public int peek() {
        if(!st2.isEmpty()) {
            return st2.peek();
        }
        else {
            while(!st1.isEmpty()) {
                st2.push(st1.peek());
                st1.pop();
            }

            return st2.peek();
        }
    }

    public boolean empty() {
        return (st2.isEmpty() && st1.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 *
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */