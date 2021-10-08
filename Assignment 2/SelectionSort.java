public class SelectionSort {
    int comparisons = 0;
    public String[] selectionSort(String[] A){
        int n = A.length;
        for(int i=0; i < n-1; i++){
            int smallpos = i;
            for(int j=i+1; j < n; j++){
                comparisons += 1;
                if(A[j].compareTo(A[smallpos]) < 0){
                    smallpos = j;
                }
            }
            String temp = A[i];
            A[i] = A[smallpos];
            A[smallpos] = temp;
        }
        return A;
    }

}
