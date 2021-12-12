public class Shuffle {
    public boolean[] shuffle(boolean[] A){
        int n = A.length;
        for(int i = 0; i < n; i++){
            // pick random number from 0 to i uniformly
            int rand = (int)(Math.random() * (i+1));
            boolean temp = A[rand];
            A[rand] = A[i];
            A[i] = temp;
        }
        return A;
    }
}
