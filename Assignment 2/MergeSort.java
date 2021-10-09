public class MergeSort {
    int comparisons = 0;
    // where start <= mid < end
////    public static void merge(String[] A int start, int mid, int end){
//        // splits A into two sub-arrays B,C
//        int n_1 = mid - start + 1;
//        int n_2 = end - mid;
//        String[] B = new String[n_1];
//        String[] C = new String[n_2];
//        int counts = 0;
//        for (int i = 0; i < n_1-1; i++){
//            B[i] = A[start + i -1];
//            counts+=1;
//        }
//        System.out.println(counts);
//        for (int j = 0; j < n_2-1; j++){
//            C[j] = A[mid + j];
//        }
//
//        // compare each sub-array element-wise and overwrite A
//        int i = 0;
//        int j = 0;
//        for(String h: B){
//            System.out.println(h);
//        }
//
//        for(int k = start; k < end; k++){
//            if(B[i].compareTo(C[i]) > 1) {
//                A[k] = B[i];
//                i = i + 1;
//            }else{
//                A[k] = C[j];
//                j = j + 1;
//            }
//        }
//    }
//
//    public static void mergeSort(String[] A, int start, int end){
//        if(start < end){
//            double double_mid = Math.floor((start + end)/2);
//            int mid = (int)double_mid;
//            mergeSort(A, start, mid);
//            mergeSort(A, mid +1, end);
//            merge(A, start, mid, end);
//        }
//    }
    public void merge(
            String[] A, String[] L, String[] R, int l, int r) {

        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            comparisons +=1;
            if (L[i].compareTo(R[j]) < 0) {
                A[k++] = L[i++];
            }else {
                A[k++] = R[j++];
            }
        }
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
