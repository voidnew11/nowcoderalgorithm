import java.util.*;

public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        // write code here
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(A[j]<A[j-1]){
                    int temp=A[j];
                    A[j]=A[j-1];
                    A[j-1]=temp;
                }
            }
        }
        return A;
    }
}
