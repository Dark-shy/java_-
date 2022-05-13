public class lcs {
    static void Longest_Common_Subsequence(char[] x, char[] y) {
        int n, m;
        n = x.length;
        m = y.length;
        int[][] c = new int[n+1][m+1];
        char[][] rec = new char[n+1][m+1];
        int i, j;
        for (i = 0; i <= n; i++)
            c[i][0] = 0;
        for (j = 0; j <= m; j++)
            c[0][j] = 0;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                if (x[i-1] == y[j-1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    rec[i][j] = '↖';
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    rec[i][j] = '↑';
                } else {
                    c[i][j] = c[i][j - 1];
                    rec[i][j] = '←';
                }
            }
        }
        System.out.println("c[][]");
        for (int m1=0;m1<=7;m1++){
            for (int n1=0;n1<=6;n1++)
                System.out.print(c[m1][n1]+" ");
        System.out.println();}
        System.out.println("Rec[][]");
        for (int m1=1;m1<=7;m1++){
            for (int n1=1;n1<=6;n1++)
                System.out.print(rec[m1][n1]+" ");
            System.out.println();}
        print_lcs(rec, x, i-1, j-1);
    }

    static void print_lcs(char[][] res, char[] x, int i, int j) {
        if (i == 0 || j == 0) return;
        if (res[i][j] == '↖') {
            print_lcs(res, x, i - 1, j - 1);
            System.out.print(x[i-1] + ",");
        } else if (res[i][j] == '↑')
            print_lcs(res, x, i - 1, j);
        else
            print_lcs(res, x, i, j - 1);

    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'b', 'd', 'a', 'b'};
        char[] b = {'b', 'd', 'c', 'a', 'b', 'a'};
        Longest_Common_Subsequence(a, b);
    }
}
