//Maximum Frequency Stack
import java.util.HashMap;
import java.util.Stack;

public class Day66_Q1 {
    HashMap<Integer, Stack<Integer>> stacksMap;
    HashMap<Integer, Integer> fmap;
    int maxFreq = 0;

    public Day66_Q1() {
        stacksMap = new HashMap<>();
        fmap = new HashMap<>();
    }

    public void push(int val) {
        fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        int freq = fmap.get(val);
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        Stack<Integer> st = stacksMap.getOrDefault(freq, new Stack<>());
        st.push(val);
        stacksMap.put(freq, st);
    }

    public int pop() {
        Stack<Integer> st = stacksMap.get(maxFreq);
        int ans = st.pop();
        fmap.put(ans, fmap.get(ans) - 1);
        if (st.isEmpty()) {
            stacksMap.remove(maxFreq);
            maxFreq--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Day66_Q1 freqStack = new Day66_Q1();
        
        // Test the push and pop methods
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        
        System.out.println(freqStack.pop()); // Expected output: 5
        System.out.println(freqStack.pop()); // Expected output: 7
        System.out.println(freqStack.pop()); // Expected output: 5
        System.out.println(freqStack.pop()); // Expected output: 4
    }
}
