import java.util.*;

public class Day66_Solution1 {

        Map<Integer, Integer> map;
        int idx;
        PriorityQueue<int[]> pq; // val, idx, freq

        public FreqStack() {
            map = new HashMap<>();

            pq = new PriorityQueue<>(
                    (a, b) -> {
                        int t = b[2] - a[2];
                        if (t != 0) {
                            return t;
                        }
                        return b[1] - a[1];
                    }
            );
        }

        public void push(int val) {

            map.put(val, map.getOrDefault(val, 0) + 1);

            idx++;

            pq.add(new int[]{val, idx, map.get(val)});
        }

        public int pop() {
            //  idx--;

            int val = pq.poll()[0];

            if (map.get(val) == 1) {
                map.remove(val);
            } else {
                map.put(val, map.get(val) - 1);
            }

            return val;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
