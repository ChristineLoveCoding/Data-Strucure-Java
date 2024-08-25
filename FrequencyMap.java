import java.util.*;
import java.util.Arrays;

public class FrequencyMap {
    public void Map(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

    }

    public static void main(String[] args) {
        int[] ai1 = {1,2,3,4};

        char a = 'A';
        char c = 'C';
        System.out.println(c-a);
        int[] input =new int[] {-1,6,10,5,7,8};
        System.out.println(longestSub(input));
        System.out.println(longestCon(input));
        System.out.println(longest(input));
        // Time : nlog(n) + O(n) -> nlog(n)
        //space test : O(1)
        String t1 = "/ 12 9";
        System.out.println(F5_Interview(t1));



    }

   public static int F5_Interview(String test){
        int res = 0;

        String[] part = test.split(" ");
       //part has 3 elements, with a length of 3
       char op = part[0].charAt(0);
       int n1 = Integer.parseInt(part[1]);
       int n2 = Integer.parseInt(part[2]);

       switch (op){
           case '+':
               return n1+n2;
           case '-':
               return n1-n2;

           case '*':
               return n1*n2;

           case '/':
               if(n2 == 0){
                   throw new ArithmeticException("can't divided by zero.");
               }

               return n1/n2;

           default:
               throw new IllegalArgumentException("invalid input ");
       }

   }

   public static void spiral(int n){

        // amount: n, n-1, n-2 , n-3 , n-4 .... 1
       // four directions: loop
       //1. goes Right ---- n ---- n-4
       //2. goes down ---- n-1 -----n-5
       //3. goes left ---- n-2
       //4. goes Up ---- n-3
       char[][] matrix = new char[n][n];
       for (int i = n; i >0 ; i--) {
            //Amount : n, n-1,n-2,... 1
           //Right, down, left , up
           //Right



       }




   }

    public static int longestSub(int[] arr){
        if (arr == null ||arr.length == 0) {
            return  -1;
        }
        int res = 0;

        Arrays.sort(arr);//nlog(n)
        for (int i = 0; i < arr.length-1; i++) {
           if(Math.abs(arr[i]-arr[i+1]) ==1){
               res++; //calculate the number of gap
           }
        }

        return res+1; //gap plus one is the exact result.
    }

    public static int longestCon(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxLength = 0;
        int currentLength = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                // Check if current element is consecutive to previous
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength); // Update maxLength
                currentLength = 1; // Reset currentLength for next subsequence
            }
        }
        maxLength = Math.max(maxLength, currentLength); // Update maxLength for last subsequence

        return maxLength;
    }

    public static int longest(int[] arr){
        int res = 1;
        Set<Integer> set = new HashSet<>();

        for(int i: arr){
            set.add(i);
        }
        Set<Integer> set2 = new HashSet<>();

        for(Integer j: set){
            if(set.contains(j-1)){
                set2.add(j);
                set2.add(j-1);
            } else if (set.contains(j+1)) {
                set2.add(j);
                set2.add(j + 1);
            }

        }

        return set2.size();
    }

}
