import java.util.*;

public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // 找最大值、最小值
        int min=A[0];
        int max=A[0];
        for(int a:A){
            min=Math.min(a,min);
            max=Math.max(a,max);
        }
        int bucketlen=max-min+1;
        int[] bucket=new int[bucketlen];
        //建桶，小于等于(a-min）的个数
        for(int a:A){
            bucket[a-min]++;
        }
        //取出内容
        int index=0;
        for(int i=0;i<bucketlen;i++){
            for(int j=0;j<bucket[i];j++){
                A[index++]=i+min;
            }
        }
        return A;
    }
}
