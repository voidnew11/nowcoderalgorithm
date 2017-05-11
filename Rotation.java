import java.util.*;
/*给定两个字符串str1、str2,判断str1、str2是否互为旋转词 */
public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(A==null||B==null||lena!=lenb)return false;
        String c=A+A;
        return c.contains(B);
    }
}
