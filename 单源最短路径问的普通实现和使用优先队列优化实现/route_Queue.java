import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class route_Queue {

    static Comparator<edge> cmp= (o1, o2) -> o1.dist -o2.dist;
    static void Dijkstar_PriQueue(int[][] G,char[] V,int s){
        Queue<edge> Q=new PriorityQueue<>(cmp);
        int[] color=new int[V.length],dist=new int[V.length],pred=new int[V.length];
        for(int i=0; i<V.length;i++){
            color[i]=0;
            dist[i]=999;
            pred[i]=0;
        }
        dist[s-1]=0;
        for (int i=0;i<V.length;i++)
            Q.add(new edge(i,dist[i]));
        int v;
        edge mum;
        while (!Q.isEmpty()){
            mum= Q.poll();
            v=mum.a;
            for (int u=0;u<V.length;u++){
                if (G[v][u] != 0 &&G[v][u]+dist[v] < dist[u]&&color[u]!=1){
                    dist[u]=G[v][u]+dist[v];
                    pred[u]=v;
                    Q.add(new edge(u,dist[u]));
                }
            }
            color[v]=1;
        }
        System.out.print("  V    ");
        for(int i=0; i<V.length;i++)
            System.out.print(V[i]+" ");
        System.out.print("\ndist[] ");
        for(int i=0; i<V.length;i++)
            System.out.print(dist[i]+" ");
        System.out.print("\npred[] N ");
        for(int i=1; i<V.length;i++)
            System.out.print(V[pred[i]]+" ");
    }
    public static void main(String[] args){
        char[] V={'s','t','x','y','z'};
        int[][] G={{0,8,0,5,0},{0,0,1,2,0},{0,0,0,0,4},{0,3,9,0,2},{0,0,6,0,0}};
        Dijkstar_PriQueue(G,V,1);
    }
}
