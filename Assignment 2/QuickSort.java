public class QuickSort {
    int comparisons = 0;
    public int partition(String[] A, int start, int end){
        end = end -1;
        String pivot = A[end];
        int i = start - 1;
        for (int j = start; j < end-1; j++){
            if(A[j].compareTo(pivot) > 0){
                i = i+1;
                String temp1 = A[i];
                A[i] = A[j];
                A[j] = temp1;
                comparisons += 1;
            }
        }
        String temp2 = A[i+1];
        A[i+1] = A[end];
        A[end] = temp2;
        comparisons += 1;
        return i+1;
    }

    public void quickSort(String[] A, int start, int end){
        if(start < end){
//            QuickSort init = new QuickSort();
            int q = partition(A, start, end);
            quickSort(A, start, q-1);
            quickSort(A, start +1, q);
        }
    }
}
