import java.util.*;

public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        // write code here
        for(int i=n/2;i>=0;i--){// build max heap
            heapify(A,i,n);
        }
        for(int i=n-1;i>0;i--){// heap sort
            int temp=A[i];
            A[i]=A[0];
            A[0]=temp;//将根节点和最后一个节点交换
            heapify(A,0,i); //最大堆调整
        }
        return A;
    }
    //堆的调整：将a[index]从下往上逐步调整树形结构
    public void heapify(int[] a,int index,int len){
      int temp = a[index];
        for(int j = 2 * index + 1; j < len; j = j * 2 + 1) {
            if(j+1 < len  && a[j] < a[j+1])
                j++;
            if(temp > a[j])
                break;
            a[index] = a[j];
            index = j;//修改index值以便继续向下调整
        }
        a[index] = temp;
  }
}
