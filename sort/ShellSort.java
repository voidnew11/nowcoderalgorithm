import java.util.*;

public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        // write code here
        if(n<=0)
           return null;

        for (int gap = n>> 1; gap > 0; gap >>= 1) { // times,gap=n/2;
           for (int i = gap; i < n; i++) { // position
            int k=i;
            while(k>=gap){
                if(A[k-gap]>A[k]){
                    swap(A,k-gap,k);
                    k-=gap;
                }else
                    break;
           }
         }
       }
        return A;
   }
   public void swap(int[] A,int l,int r){
       int temp=A[l];
       A[l]=A[r];
       A[r]=temp;
  }
}
