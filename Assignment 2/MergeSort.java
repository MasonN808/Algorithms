public class MergeSort {
    int comparisons = 0;
    public void merge(
            String[] A, String[] L, String[] R, int l, int r) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l && j < r) {
            comparisons +=1;
            //add the elements to A when comparing L and R
            if (L[i].compareTo(R[j]) < 0) {
                A[k++] = L[i++];
            }else {
                A[k++] = R[j++];
            }
        }
        //these take into account the leftovers
        while (i < l) {
            comparisons +=1;
            A[k++] = L[i++];
        }
        while (j < r) {
            comparisons +=1;
            A[k++] = R[j++];
        }
    }
    public void mergeSort(String[] A, int end) {
        if (end < 2) {
            return;
        }
        int mid = end / 2;
        String[] L = new String[mid];
        String[] R = new String[end - mid];

        for (int i = 0; i < mid; i++) {
            comparisons += 1;
            L[i] = A[i];
        }
        for (int i = mid; i < end; i++) {
            comparisons += 1;
            R[i - mid] = A[i];
        }
        mergeSort(L, mid);
        mergeSort(R, end - mid);

        merge(A, L, R, mid, end - mid);
    }
}
