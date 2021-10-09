public class QuickSort {
    int comparisons = 0;
    // set private so not accessible outside of class
    private int partition(String[] A, int start, int end){
        String pivot = A[end];
        int i = start - 1;
        for (int j = start; j < end; j++){
            comparisons += 1;
            if(A[j].compareTo(pivot) < 0){
                i += 1;
                // swap A[i] and A[j]
                String temp1 = A[i];
                A[i] = A[j];
                A[j] = temp1;
            }
        }
        // swap A[i+1] and A[end]
        String temp2 = A[i+1];
        A[i+1] = A[end];
        A[end] = temp2;
        return i+1;
    }

    public void quickSort(String[] A, int start, int end){
        if(start < end){
//            QuickSort init = new QuickSort();
            int q = partition(A, start, end);
            quickSort(A, start, q-1);
            quickSort(A, q +1, end);
        }
    }
}
