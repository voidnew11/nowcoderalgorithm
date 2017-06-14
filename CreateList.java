public  class CreatList{
public List<Integer> merge(List l1,List l2,int len,int step){
    List<Integer> l3=new ArrayList<Integer>();
    int len1=l1.length();
    int len2=l2.length();
    int p1=p2=curlen=0;
    boolean flag=false;//false表走l1,true表走l2
    while(curlen<len){
        if(!flag){
            for(int i=0;i<step;i++){
                if(p1+i<len1){
                    l3.add(l1.get(p1));
                    p1+=i;
                }else
                    break;
            }
        }else{
            for(int j=0;j<step;j++){
                if(p2+j<len2){
                    l3.add(l2.get(p2));
                    p2+=j;
                }else
                    break;
            }
        }
        flag=!flag;
        curlen+=step;
    }
    return l3;
 }
}
