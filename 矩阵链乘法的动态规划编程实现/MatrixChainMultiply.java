
// 矩阵连乘
public class MatrixChainMultiply {
    public static void matrixChainMultiply(int[] p, int n) {
        int[][] D = new int[n][n];
        int[][] Rec = new int[n][n];
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[i].length; j++) {
                D[i][j] = Integer.MAX_VALUE;
            }
            D[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k <= j - 1; k++) {
                    int q = D[i][k] + D[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < D[i][j]) {
                        D[i][j] = q;
                        Rec[i][j] = k;
                    }
                }
            }
        }
        out(D, Rec, p);
    }

    public static void out(int[][] D, int[][] Rec, int[] p) {
        System.out.println("p[]");
        for (int i : p) {
            System.out.print(" " + i);
        }
        System.err.println();
        System.out.println("D[][]");
        for (int i = 1; i < D.length; i++) {
            for (int j = 1; j < D.length; j++) {
                if (D[i][j] == Integer.MAX_VALUE) {
                    System.out.printf("%4d", 0);
                } else {
                    System.out.printf("%4d", D[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Rec[][]");
        for (int i = 1; i < Rec.length; i++) {
            for (int j = 1; j < Rec.length; j++) {
                System.out.printf("%4d", Rec[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] p = { 2, 3, 7, 9, 5, 2, 4 };
        matrixChainMultiply(p, p.length);
    }
}
