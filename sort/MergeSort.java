import java.util.*;

public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        // write code here
        sort(A,0,n-1);
        return A;
    }
    public void sort(int[] a,int l,int r){
        if(l>=r)
            return;
        int mid=l+(r-l)/2;
        sort(a,l,mid);
        sort(a,mid+1,r);
        merge(a,l,mid,r);
    }
    public void merge(int[] a,int l,int mid,int r){
        int i=l,j=mid+1,k=0;
        int[] temp=new int[r-l+1];
        while(i<=mid && j<=r){
            if(a[i]<a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        while(i<=mid)
            temp[k++]=a[i++];

        while(j<=r)
            temp[k++]=a[j++];

        for(int m=0;m<temp.length;m++)
            a[l+m]=temp[m];
    }
}
