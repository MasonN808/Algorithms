public class Linear {
    int comparisons = 0;
    public int linear_search(String[] A, String target){
        int n = A.length;
        for(int i = 0; i < n; i++){
            comparisons += 1;
            if(A[i] == target){
                // return index of target in array
                return i;
            }
        }
        // if target is not in array
        return -1;
    }
}
