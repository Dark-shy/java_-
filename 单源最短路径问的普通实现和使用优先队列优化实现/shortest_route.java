public class shortest_route {
    static void Dijkstar(int[][] G,char[] V,int s){
        int[] color=new int[V.length],dist=new int[V.length],pred=new int[V.length];
        for(int i=0; i<V.length;i++){
            color[i]=0;
            dist[i]=999;
            pred[i]=0;
        }
        dist[s-1]=0;
        int minDist,rec;
        for (int i=0;i<V.length;i++){
            minDist=999;
            rec=0;
            for (int j=0;j<V.length;j++){
                if (color[j] != 1&&dist[j]<=minDist){
                    minDist=dist[j];
                    rec=j;
                }
            }
            for (int u=0;u<V.length;u++){
                if (G[rec][u]!=0&&(G[rec][u]+dist[rec])<dist[u]&&color[u]!=1){
                    dist[u]=G[rec][u]+dist[rec];
                    pred[u]=rec;
                }
            }
            color[rec]=1;
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
        Dijkstar(G,V,1);
    }
}
