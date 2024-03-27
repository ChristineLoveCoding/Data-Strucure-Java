import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CohereOA {

    public static void main(String[] args) {
        int n = 15959;
        int n1= 5859;
       

        String testS = "011100";
        System.out.println(solution(testS));



    }

    public static int max(int N){
        int max = Integer.MIN_VALUE;
        String ns = String.valueOf(N);
        for (int i = 0; i < ns.length(); i++) {
            if(ns.charAt(i) == '5'){
                String a = ns.substring(0,i);
                String b = ns.substring(i+1);
                String c = a+b;
                int d = Integer.parseInt(c);
                max = Math.max(max, d);

            }
        }


        return max;
    }

    public static int solution(String s){

        char[] c = s.toCharArray();
        int res = 0, ans=0;
        int l = c.length;
        for (int i = l-1; i >= 0 ; i--) {
            if(c[i] == '1'){
                ans++;
                res = l - i -1;
            }

        }

        return ans+res;


    }
}
