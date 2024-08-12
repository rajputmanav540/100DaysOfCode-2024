class Solution {
    int[][] sortedMatrix(int N, int Mat[][]) {
        int[] flatArray = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flatArray[index++] = Mat[i][j];
            }
        }
        Arrays.sort(flatArray);
        index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Mat[i][j] = flatArray[index++];
            }
        }

        return Mat;
    }
}
