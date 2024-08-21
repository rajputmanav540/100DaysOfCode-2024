import java.util.*;
public class Day61_Solution2 {
        public int maximalRectangle(char[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            if(matrix.length == 0) return 0;

            int maxArea = 0;
            int[] height = new int[m];


            for(int i =0;i<n;i++){
                for(int j =0;j< m;j++){

                    height[j] = matrix[i][j] == '1' ? height[j] +1 : 0;

                }
                maxArea = Math.max(maxArea, largestArea(height));
            }
            return maxArea;
        }
        private int largestArea(int[] height){
            Stack<Integer> stack = new Stack<>();
            int maxArea =0;
            for(int i=0;i<=height.length;i++){
                int current = (i == height.length) ? 0 : height[i];

                while(!stack.isEmpty() && current< height[stack.peek()]){
                    int heights = height[stack.pop()];
                    int width = stack.isEmpty() ? i: i - stack.peek() -1;
                    maxArea = Math.max(maxArea, heights * width);

                }
                stack.push(i);

            }
            return maxArea;
        }

    }



