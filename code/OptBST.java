public class OptBST{
    public static void main(String[] args) {
        float[] P = {(float) 0.1,(float) 0.2,(float) 0.4,(float) 0.3};
        System.out.println("输出表达最优二叉排序树形状的矩阵：\n");
        int[][] R = OptBST(P);
        for(int i = 0;i < R.length;i++)
        {
            for(int j = 0;j < R.length;j++)
                System.out.print(R[i][j] + "　　");
            System.out.println();
        }

    }
    public static int[][] OptBST(float[] P){
        int n = P.length;
        float[][] result = new float[n][n];

        int[][] R = new int[n][n];

        for(int i = 0;i < n;i++)
        {
            result[i][i] = P[i];
            R[i][i] = i;
        }
        for(int d = 1;d <= n - 1;d++)
        {
            for(int i = 0;i <= n - d - 1;i++)
            {
                int j = i + d;
                float min = 1000000;
                int root = 0;
                for(int k = i;k <= j;k++)
                {
                    float C1 = 0,C2 = 0;
                    if(k > i)
                        C1 = result[i][k - 1];
                    if(k < j)
                        C2 = result[k + 1][j];
                    if(C1 + C2 < min)
                    {
                        min = C1 + C2;
                        root = k;
                    }
                }
                R[i][j] = root;
                float sum = 0;
                for(int s = i;s <= j;s++)
                    sum = sum + P[s];
                result[i][j] = sum + min;
            }
        }
       return R; //返回表达最优二叉排序树形状的矩阵
    }
}
