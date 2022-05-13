public class Maxarray {
    public static int max(int a,int b ,int c){
        if(a>b)
            return Math.max(a,c);
        else
            return Math.max(b,c);
    }
    public static int CrossingSubArray(int[] a,int low,int high,int mid){
        int Sl=Integer.MIN_VALUE,sum=0;
        for (int l = mid ; l >= low ; l--){
            sum+=a[l];
            Sl=max(sum,Sl,sum);
        }
        int Sr=Integer.MIN_VALUE;sum = 0;
        for (int r= mid+1;r <= high;r++){
            sum+=a[r];
            Sr=max(sum,Sr,sum);
        }
            return Sr + Sl;
    }
    public static int maxsubarry(int[] a,int low,int high){
        if(low == high)
            return a[low];
        int mid = (low+high)/2;
        int S1=maxsubarry(a,low,mid);
        int S2=maxsubarry(a,mid+1,high);
        int S3=CrossingSubArray(a,low,high,mid);
        return max(S1,S2,S3);
}
    public static void main(String[] args){
        int[] a ={1,-2,4,5,-2,8,3,-2,6,3,7,-1};
        int max;
        max=maxsubarry(a,0,11);
        System.out.print(max+"");
    }
}