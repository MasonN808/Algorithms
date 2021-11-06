public class RelativeInsertionSort {
    public void relative_insertionSort(int[] A, String[] B){
        int n = A.length;
        for(int i = 1; i < n; i++){
            int key = A[i];
            String keyB = B[i];
            int j = i-1;
//            comparisons += 1;
            // if A[j] does not need to be switched, skip while
            while(j >= 0 && A[j] > key){
                A[j+1] = A[j];
                B[j+1] = B[j];
                j = j-1;
            }
            A[j+1] = key;
            B[j+1] = keyB;
        }
    }
}
