/**
 * Problem: Asteroid Collision (#735)
 * Date: 16-09-2026
 *
 * ------------------------------------------------------------
 * Approach: Stack Simulation

 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * ------------------------------------------------------------
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // List is used as a stack
        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < asteroids.length; i++) {

            // Positive asteroid moves to the right
            if(asteroids[i] > 0) {
                li.add(asteroids[i]);
            }

            else {

                // Remove smaller positive asteroids
                // that collide with the current negative asteroid
                while(li.size() != 0 &&
                      (li.get(li.size() - 1) > 0) &&
                      (li.get(li.size() - 1) < Math.abs(asteroids[i]))) {

                    li.remove(li.size() - 1);
                }

                // Both asteroids have the same magnitude,
                // so both are destroyed
                if(li.size() != 0 &&
                   li.get(li.size() - 1) == Math.abs(asteroids[i])) {

                    li.remove(li.size() - 1);

                    // continue;
                }

                // No asteroid to collide with, or the top asteroid
                // is moving left, so the current asteroid survives
                else if(li.size() == 0 ||
                        li.get(li.size() - 1) < 0) {

                    li.add(asteroids[i]);
                }
            }
        }

        // Convert the List into an array
        int[] arr = new int[li.size()];

        for(int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }

        return arr;
    }
}