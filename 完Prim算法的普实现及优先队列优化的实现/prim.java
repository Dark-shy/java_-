public class prim {
    static void MST_Prim(int[][] G,char[] V){
        int[] color=new int[V.length],dist=new int[V.length],pred=new int[V.length];
        for(int i=0; i<V.length;i++){
            color[i]=0;
            dist[i]=999;
            pred[i]=0;
        }
        dist[0]=0;
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
                if (G[rec][u]!=0&&G[rec][u]<dist[u]&&color[u]!=1){
                    dist[u]=G[rec][u];
                    pred[u]=rec;
                }
            }
            color[rec]=1;
        }
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
        MST_Prim(G,V);
    }
}
