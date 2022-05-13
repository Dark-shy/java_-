public class activity {
    static void choose_activity(String[] S, int[] s, int[] f){
        StringBuilder S1= new StringBuilder(S[0]);
        int k=0,n=S.length;
        for (int i=1;i<n;i++){
            if (s[i] >= f[k]){
                S1.append(S[i]);
                k=i;
            }
        }
        System.out.println(S1);
    }
    public static void main(String[] args){
        String[] S={"a1 ","a2 ","a3 ","a4 ","a5 ","a6 ","a7 ","a8 ","a9 ","a10 ","a11 ",};
        int[] s={1,3,0,5,3,5,6,8,8,2,12};
        int[] f={4,5,6,7,8,9,10,11,12,13,14};
        choose_activity(S,s,f);
    }
}
