public class SelectionSort {
    int comparisons = 0;
    public String[] selectionSort(String[] A){
        int n = A.length;
        for(int i=0; i < n-1; i++){
            comparisons += 1;
            int smallpos = i;
            for(int j=i+1; j < n; j++){
                comparisons += 1;
                // see if A[j] is greater than A[smallpos] Alphabetically
                if(A[j].compareTo(A[smallpos]) < 0){
                    // if so, switch
                    smallpos = j;
                }
            }
            //replace A[i] with the smallest value
            String temp = A[i];
            A[i] = A[smallpos];
            A[smallpos] = temp;
        }
        return A;
    }

}
