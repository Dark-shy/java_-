import java.util.Scanner;

public class ZeroOnePack{

    int N,V;
    private int[] weight;
    private int[] value;
    private int[][] F;

    public void ZeroOnePackNonRecursive() {
        for(int j = 0; j <= V; j++) {
            F[0][j] = 0;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                if(j >= weight[i]) {
                    F[i][j] = Math.max(F[i - 1][j - weight[i]] + value[i], F[i - 1][j]);
                }else {
                    F[i][j] = F[i - 1][j];
                }
            }
        }

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printResult(int n, int v) {
        boolean[] isAdd = new boolean[n + 1];

        for(int i = n; i >= 1; i--) {
            if(F[i][v] == F[i-1][v])
                isAdd[i] = false;
            else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(isAdd[i] + " ");
        }
        System.out.println();
    }

    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();

        weight = new int[N + 1];
        value = new int[N + 1];
        F= new int[N + 1][V + 1];
        for(int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            value[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        ZeroOnePack zop = new ZeroOnePack();
        zop.init();
        zop.ZeroOnePackNonRecursive();
        zop.printResult(zop.N,zop.V);
    }
}

