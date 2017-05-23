import java.util.*;
/* 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
给定一个int数组A及它的大小n，请返回它是否有重复值。
思路：模仿hashset,借鉴了计数排序中的方法*/
public class Checker1 {
    public boolean checkDuplicate(int[] a, int n) {
        // write code here
        int min=a[0];
        int max=a[0];
        for(int m:a){
            min=Math.min(m,min);
            max=Math.max(m,max);
        }
        int clen=max-min+1;
        int[] count=new int[clen];
        int k=0;
        for(int i=0;i<n;i++){
            k=a[i]-min;
            count[k]++;//借鉴计数排序
            if(count[k]>1)
                return true;
        }
        return false;
    }
}
