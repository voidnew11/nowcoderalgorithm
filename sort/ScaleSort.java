import java.util.*;
/* 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
请选择一个合适的排序算法针对这个数据进行排序。
给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
思路：采用堆排序，数组0~K-1中必然有整个数组的最小值，1~k中必然有第二大的数，以此类推
所以，只要建立一个节点为K的小根堆，每次对K个数进行调整，吐出堆顶，加入第K+1个数，遍历整个数组，排序就完成了*/
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        // write code here
        if(A==null || n<2 ||n<k)
            return A;
        int[] heap=getKHeap(A,k);//构建大小为k的最小堆
        for(int i=k;i<n;i++){
           A[i-k]=heap[0];//heap[0]是0~k-1中的最小值
           heap[0]=A[i];
           heapify(heap,0,k);//调整堆大小，范围为1~k
        }
        for(int i=n-k;i<n;i++){
            A[i]=heap[0];
            swap(heap,0,k-1);//将堆顶元素和最后一个元素互换
            heapify(heap,0,--k); //调整剩下的堆
        }
      return A;
    }
    public int[] getKHeap(int[] A,int k){
        int[] heap=new int[k];
        for(int i=0;i<k;i++){
            heapInsert(heap,A[i],i);
        }
       return heap;
    }
    public void heapInsert(int[] A,int value,int index){
        A[index]=value;
        while(index!=0){
            int parent=(index-1)/2;
            if(A[parent]>A[index]){
                swap(A,parent,index);//将小的数放前面
                index=parent;
            }else
                break;
        }
    }
    public void swap(int[] a,int m,int n){
        int temp=a[m];
        a[m]=a[n];
        a[n]=temp;
    }
    public void heapify(int[] a,int index,int heapsize){
        int left=2*index+1;
        int right=2*index+2;
        int small=index;
        while(left<heapsize){
            if(a[left]<a[index])
                small=left;
            if(right<heapsize && a[right]<a[small])
                small=right;
            if(index!=small){
                swap(a,small,index);//把最小值放在堆顶
            }else
                break;
           index=small;
           left=2*index+1;
           right=2*index+2;
        }
    }
}
