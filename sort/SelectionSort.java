import java.util.*;

public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
        // write code here
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[min])
                    min=j;
            }
            int temp=A[i];
            A[i]=A[min];
            A[min]=temp;
        }
        return A;
    }
}
