import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
//自定义堆的数据类型
class edge{
    int a;
    int dist;
    edge (int a,int dist){
        this.dist=dist;
        this.a=a;;
    }
}
public class prim_pri_queue {
    static Comparator<edge> cmp= (o1, o2) -> o1.dist -o2.dist;
    static void MST_Prim_PriQueue(int[][] G,char[] V){
        Queue<edge> Q=new PriorityQueue<>(cmp);
        int[] color=new int[V.length],dist=new int[V.length],pred=new int[V.length];
        //初始化
        for(int i=0; i<V.length;i++){
            color[i]=0;
            dist[i]=999;
            pred[i]=0;
        }
        dist[0]=0;
        for (int i=0;i<V.length;i++){
            Q.add(new edge(i,dist[i]));
        }
        //算法实现
        int v;
        edge mum;
        while (!Q.isEmpty()){
            mum= Q.poll();
            v=mum.a;
            for (int u=0;u<V.length;u++){
                if (G[v][u] != 0 &&G[v][u] < dist[u]&&color[u]!=1){
                    dist[u]=G[v][u];
                    pred[u]=v;
                    Q.add(new edge(u,dist[u]));
                }
            }
            color[v]=1;
        }
        //最小生成子树的输出
        int add_right=0;
        System.out.println("dist[]");
        for(int i=0; i<V.length;i++){
            System.out.print(dist[i]+" ");
            add_right+=dist[i];
        }
        System.out.println("\npred[]");
        for(int i=0; i<V.length;i++)
            System.out.print(pred[i]+" ");
        System.out.print("\n最小权值"+add_right);
    }
    public static void main(String[] args){
        //图G的输入
        char[] V={'a','b','c','d','f','g','h','i','z'};
        int[][] G={{0,4,0,0,0,0,8,0,0},
                {4,0,8,0,0,0,1,0,0},
                {0,8,0,7,4,0,0,2,0},
                {0,0,7,0,14,0,0,0,9},
                {0,0,4,14,0,2,0,0,10},
                {0,0,0,0,2,0,1,4,0},
                {8,1,0,0,0,1,0,7,0},
                {0,0,2,0,0,4,7,0,0},
                {0,0,0,9,10,0,0,0,0}};
        MST_Prim_PriQueue(G,V);
    }
}
