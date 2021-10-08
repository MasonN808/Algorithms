public class InserstionSort {
    int comparisons = 0;
    public String[] insertionSort(String[] A){
        int n = A.length;
        for(int i = 1; i < n; i++){
            String key = A[i];
            int j = i-1;
//            comparisons += 1;
            while(j >= 0 && A[j].compareTo(key) > 0){
                comparisons += 1;
                A[j+1] = A[j];
                j = j-1;
            }
            A[j+1] = key;
        }
        return A;
    }
}
