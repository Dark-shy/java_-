public class matrix{
    public static void  Matrix_Chain_Multiply(int[] p,int n){
        int[][] D=new int [n][n];
        int[][] Rec=new int[n][n];
        int j,q,i;
        for ( i = 0; i < D.length; i++) {
            for ( j = 0; j < D[i].length; j++) {
                    D[i][j] = Integer.MAX_VALUE;
                }
                D[i][i] = 0;
        }
        for (int l = 2;l <= n; l++){
            for ( i = 1;i < n-l+1;i++) {
                j = i + l - 1;
                for (int k = i; k <= j - 1; k++) {
                    q = D[i][k] + D[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < D[i][j]) {
                        D[i][j] = q;
                        Rec[i][j] = k;
                    }
                }
            }
        }
        q=0;
        System.out.print("D[][]\nj=     1   2   3   4   5   6\n");
        for (i=1;i<7;i++){
            System.out.print("i="+(i+1)+" ");
            for (j=1;j<7;j++)
                if(j>i)
                System.out.printf("%4d",D[i][j]);
                else System.out.printf("%4d",q);
            System.out.println();
        }
        System.out.print("Rec[][]\nj=    1  2  3  4  5  6\n");
        for (i=1;i<6;i++){
            System.out.print("i="+(i+1)+" ");
            for (j=1;j<7;j++)
                System.out.printf("%3d",Rec[i][j]);
            System.out.println();
        }
        Print(Rec,n,n);
    }
    public static void Print(int[][] Rec,int i,int j){
        if( i == j){
            System.out.print("U"+i);
        return;}
        System.out.print("<");
        Print(Rec,i,Rec[i][j]);
        System.out.print("><");
        Print(Rec,Rec[i][j]+1,j);
        System.out.print(">");
    }
    public static void main(String[] args){
        int[] p={ 2, 3, 7, 9, 5, 2 ,4 };
        Matrix_Chain_Multiply(p,p.length);
    }
}