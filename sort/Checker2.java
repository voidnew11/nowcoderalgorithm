import java.util.*;
/* 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
给定一个int数组A及它的大小n，请返回它是否有重复值。
思路：先排序，再判断，排序用非递归实现的堆排序*/
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // 采用堆排序
        if(a==null || n<2)
            return false;
        heapSort(a,n);
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1])
                return true;
        }
        return false;
    }
    public void heapSort(int[] a,int n){
        for(int i=0;i<n;i++){
            heapInsert(a,i);//构建大根堆
        }
        for(int i=n-1;i>0;i--){
            swap(a,0,i);
            heapify(a,0,i);//调整大根堆
        }
    }
    public void swap(int[] a,int m,int n){
        int temp=a[m];
        a[m]=a[n];
        a[n]=temp;
    }
    public void heapInsert(int[] a,int index){
        while(index!=0){
          int parent=(index-1)/2;
          if(a[parent]<a[index]){
              swap(a,parent,index);
              index=parent;
          }else break;
        }
    }
    public void heapify(int[] a,int index,int heapsize){
       int left=2*index+1;
       int right=2*index+2;
       int large=index;
       while(left<heapsize){
           if(a[left]>a[index])
               large=left;
           if(right<heapsize && a[right]>a[large])
               large=right;
           if(large!=index){
               swap(a,large,index);
           }else break;
           index=large;
           left=2*index+1;
           right=2*index+2;
       }
    }
}
