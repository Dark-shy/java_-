public class loading {
    //装载方法
    static void Loading(container[] a,int C){
        //按照weight从小到大排序
        String number;
        int weight;
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if(a[i].weight>a[j].weight){
                    number=a[i].number;
                    a[i].number=a[j].number;
                    a[j].number=number;
                    weight=a[i].weight;
                    a[i].weight=a[j].weight;
                    a[j].weight=weight;
                }
            }
        }
        int mel=0,i=0;
        while (i<a.length && a[i].weight<=C){
            mel+=a[i].weight;
            C-=a[i].weight;
            i++;
        }
        System.out.println("最大装载量:"+mel+"\n解向量集合为");
        for (;i>=0;i--){
            System.out.print(a[i].number+" ");
        }
    }
    public static void main(String[] args){
        int C=200;
        container[] a=new container[10];
        for (int i=0;i<10;i++)
            a[i]=new container();
        a[0].container("a1",10);
        a[1].container("a2",55);
        a[2].container("a3",88);
        a[3].container("a4",66);
        a[4].container("a5",77);
        a[5].container("a6",58);
        a[6].container("a7",22);
        a[7].container("a8",11);
        a[8].container("a9",57);
        a[9].container("a10",66);
        Loading(a,C);
    }
}
//集装箱类
class container{
    String number;
    int weight;
    void container(String number,int weight){
        this.number=number;
        this.weight=weight;
    }

}