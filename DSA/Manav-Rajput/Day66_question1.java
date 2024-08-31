import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    private Map<Integer, Integer> freqMap; // To store the frequency of each element
    private Map<Integer, Stack<Integer>> groupStackMap; // To store stacks of elements with the same frequency
    private int maxFreq; // To track the current maximum frequency

    public FreqStack() {
        freqMap = new HashMap<>();
        groupStackMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // Update the frequency of the element
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        // Update the maximum frequency if necessary
        if (freq > maxFreq) {
            maxFreq = freq;
        }

        // Add the element to the stack corresponding to its frequency
        groupStackMap.computeIfAbsent(freq, x -> new Stack<>()).push(val);
    }

    public int pop() {
        // Get the element from the stack of the current max frequency
        int val = groupStackMap.get(maxFreq).pop();

        // Decrease the frequency of the element
        freqMap.put(val, freqMap.get(val) - 1);

        // If the stack of the current max frequency becomes empty, decrease maxFreq
        if (groupStackMap.get(maxFreq).isEmpty()) {
            maxFreq--;
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
