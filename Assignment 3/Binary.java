public class Binary {
    int comparisons = 0;
    public int binary_search(String[] A, int left, int right, String target){
        if (left <= right){
            // get the middle string between right and left points in A
            int middle = left + (right - left)/2;
            if (A[middle] == target){
                // found target in A
                return middle;
            }
            // compare strings A[middle] and target
            // if target is less than middle go left
            if (A[middle].compareTo(target) < 0){
                return binary_search(A, left, middle-1, target);
            }
            else{
                // if target is greater than middle go right
                return binary_search(A, middle + 1, right, target);
            }
        }
        // if target not in A
        return -1;
    }
}
