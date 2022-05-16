public class part_backpack {
    static void FractionalKnapsack(String[] goods,int n,int[] p,int[] v,int C){
        int i=0,ans=0;
        while (C>0&&i<n){
            if (v[i]<C){
                System.out.println("选择商品"+goods[i]);
                ans+=p[i];
                C-=v[i];
            }
            else {
                System.out.println("选择商品" + goods[i] + " " + (p[i] * C / v[i])+"ml");
                ans+=p[i] * C / v[i];
                C=0;
            }
            i++;
        }
        System.out.println("max价格："+ans);
    }
    public static void main(String[] args){
        int[] p={36,16,45,60,10};
        int[] v={200,100,300,600,250};
        int C=800;
        String[] goods={"橙汁","苹果汁","西瓜汁","苏打水","汽水"};
        FractionalKnapsack(goods,goods.length,p,v,C);
    }
}
