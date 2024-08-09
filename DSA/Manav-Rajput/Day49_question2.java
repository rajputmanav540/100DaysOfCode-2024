class Solution {
    
    static class Element implements Comparable<Element> {
        int value, row, col;

        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Element other) {
            return this.value - other.value;
        }
    }

    public static int kthSmallest(int[][] mat, int n, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(new Element(mat[i][0], i, 0));
        }

        for (int i = 0; i < k - 1; i++) {
            Element e = minHeap.poll();
            if (e.col + 1 < n) {
                minHeap.add(new Element(mat[e.row][e.col + 1], e.row, e.col + 1));
            }
        }
        return minHeap.peek().value;
    }
}
