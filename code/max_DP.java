public class max_DP {
    static void Max_Continuous_Subarray_DP(int[] x){
        int n=x.length;
        int[] D=new int[n];
        int[] Rec=new int[n];
        Rec[n-1]=n-1;
        D[n-1]=x[n-1];
        for (int i = n-2;i>=0;i--){
            if(D[i+1]>0) {
                D[i] = x[i] + D[i + 1];
                Rec[i]=Rec[i+1];
            }
            else {
                D[i]=x[i];
                Rec[i]=i;
            }
        }
        int max=D[0],l = 0,r = Rec[0];
        for (int i=2;i<n;i++){
            if (max<D[i]){
                max=D[i];
                l=i;
                r=Rec[i];
            }
        }
        System.out.println("Smax="+max);
        for (int i=l;i<=r;i++)
            System.out.print(x[i]+" ");
    }
    public static void main(String[] args){
        int[] x={4,2,3,-5,3,1};
        Max_Continuous_Subarray_DP(x);
    }
}
