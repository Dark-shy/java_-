public class activity_Right{
        private static class Activity{
            int startTime;
            int endTime;
            int weight;
                private Activity(int startTime, int endTime, int weight){
                this.startTime = startTime;
                this.endTime = endTime;
                this.weight = weight;
            }
        }
        private static void activityChoose(Activity[] S){
            int[] p = new int[S.length+1];
            p[0] = 0;
            p[1] = 0;
            for(int i=2; i<=S.length; i++){
                for(int j=i-1; j>0; j--){
                    if(S[j-1].endTime <= S[i-1].startTime){
                        p[i] = j;
                        break;
                    }
                }
            }
            int[] D = new int[S.length+1];
            int[] Rec = new int[S.length+1];
            D[0] = 0;
            // 动态规划
            for(int j=1; j<S.length+1; j++){
                if(D[p[j]]+S[j-1].weight > D[j-1]){
                    D[j] = D[p[j]] + S[j-1].weight;
                    Rec[j] = 1;
                }else{
                    D[j] = D[j-1];
                    Rec[j] = 0;
                }
            }
            System.out.println("选择方案的序号：");
            int k=S.length;
            while(k > 0){
                if(Rec[k] == 1){
                    System.out.print(" 活动"+k);
                    k = p[k];
                }else{
                    k--;
                }
            }
        }
        private static void quickSortActivity(Activity[] S, int start, int end){
            int i = start;
            int j = end;
            if (start < end){
                Activity tmp = S[i];
                while(i<j){
                    while(i<j && S[i].endTime <= S[j].endTime){
                        j--;
                    }
                    S[i] = S[j];
                    while (i < j && S[i].endTime >= S[j].endTime) {
                        i++;
                    }
                    S[j] = S[i];
                }
                S[i] = tmp;
                quickSortActivity(S, start, i-1);
                quickSortActivity(S, i+1,end);
            }
        }
        public static void main(String[] args){
            Activity[] S = new Activity[10];
            S[0] = new Activity(1,4,1);
            S[1] = new Activity(3,5,6);
            S[2] = new Activity(0,6,4);
            S[3] = new Activity(4,7,7);
            S[4] = new Activity(3,9,3);
            S[5] = new Activity(5,9,12);
            S[6] = new Activity(6,10,2);
            S[7] = new Activity(8,11,9);
            S[8] = new Activity(8,12,11);
            S[9] = new Activity(2,14,8);
            quickSortActivity(S, 0, 9);
            activityChoose(S);
        }
    }




