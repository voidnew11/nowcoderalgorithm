import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
/*按层打印二叉树，设置两个指针last、nlast;last-指向当前行最右点,初始为root，nlast-指向下一行最右点*/
public class TreePrinter {
    public int[][] printTree(TreeNode root) {

        if(root==null)
           return null;
        //辅助的队列
        LinkedList<TreeNode> quenen=new LinkedList<TreeNode>();
        //存放一行数据的数组
        ArrayList<Integer> arr= new ArrayList<Integer>();
        //存放所有行的列表
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
        //辅助变量last-当前行最右节点，nlast-下一行最右点，temp-记录当前弹出队列的节点
        TreeNode last=root;
        TreeNode nlast=null;
        TreeNode temp=null;
        //1、将头节点入队
        quenen.add(last);
        //只有辅助队列不为空，就一直进行遍历操作，按层遍历，即宽度优先遍历
        while(!quenen.isEmpty()){
            //2、弹出队首节点，并将节点放入行数组
            temp=quenen.poll();
            arr.add(temp.val);
            //3、当前弹出节点的左右节点存在的话，就分别入队，并令nlast跟踪每个入队的节点
            if(temp.left!=null){
                quenen.add(temp.left);
                nlast=temp.left;
            }
            if(temp.right!=null){
                quenen.add(temp.right);
                nlast=temp.right;
            }
            //4、换行：当当前出队节点等于last，表明到达行尾，应该换行；将行数组加入行列表，行数组清空，
            //将nlast赋给last
            if(temp==last){
                ans.add(arr);
                arr=new ArrayList<Integer>();
                last=nlast;
            }
        }
        //遍历结束后，将链表转换为二维数组
        int[][] a=new int[ans.size()][];
        for(int i=0;i<ans.size();i++){
          a[i]=new int[ans.get(i).size()];
            for(int j=0;j<a[i].length;j++){
                a[i][j]=ans.get(i).get(j);
            }
        }
      return a;
    }
}
