import java.util.*;

public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        // write code here
        if(n==0)
            return null;
        sort(A,0,n-1);
        return A;
    }
    public void sort(int[] a,int l,int r){
        if(l>=r)
            return;
        int i=l,j=r;
        int index=a[l];
        while(i<j){
            while(i<j && a[j]>=index)
                j--;
            if(i<j)
                a[i++]=a[j];
            while(i<j && a[i]<index)
                i++;
            if(i<j)
                a[j--]=a[i];
        }
        a[i]=index;//i与j相遇
        sort(a,l,i-1);
        sort(a,i+1,r);
    }
}
