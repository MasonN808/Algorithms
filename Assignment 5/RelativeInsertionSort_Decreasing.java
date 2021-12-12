public class RelativeInsertionSort_Decreasing {
    public void relative_insertionSort_decreasing(float[] A, Spice[] B) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            float key = A[i];
            Spice keyB = B[i];
            int j = i - 1;
//            comparisons += 1;
            // if A[j] does not need to be switched, skip while
            while (j >= 0 && A[j] < key) {
                A[j + 1] = A[j];
                B[j + 1] = B[j];
                j = j - 1;
            }
            A[j + 1] = key;
            B[j + 1] = keyB;
        }
    }

    public void relative_insertionSort_increasing(int[] A, int[][] B) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            int key = A[i];
            int[] keyB = B[i];
            int j = i - 1;
//            comparisons += 1;
            // if A[j] does not need to be switched, skip while
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                B[j + 1] = B[j];
                j = j - 1;
            }
            A[j + 1] = key;
            B[j + 1] = keyB;
        }
    }
}