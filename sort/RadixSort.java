import java.util.*;

public class RadixSort {
    public int[] radixSort(int[] A, int n) {
        // write code here
        if(A==null || n<2)
            return A;
        int index=0;//标记输出结果
        int a=1;//分离数的各个整数位
        int m=1;//指向的位数
        //高维表示0-9个桶，低维表示每个关键字各整数位数量,每个桶内可能有n个值
        int[][] number=new int[10][n];
        //此数组表示个整数位数量，整数位范围0-9；
        int[] c=new int[10];
        while(m<=4){
            //建桶
            for(int i=0;i<n;i++){
                int ls=((A[i]/a)%10);//得到余数
                number[ls][c[ls]]=A[i];
                c[ls]++;//余数为ls,在哪个桶内也确定，因此将桶内的数目自加
            }
            //取出内容
            for(int i=0;i<10;i++){
                if(c[i]!=0){//判断在哪个桶内的并且在该桶内的关键字的个数不为0
                    for(int j=0;j<c[i];j++){
                        A[index]=number[i][j];
                        index++;
                    }
                }
               c[i]=0;
            }
           index=0;
           a*=10;
           m++;
        }
      return A;
    }
}
