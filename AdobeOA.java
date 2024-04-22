import java.util.HashMap;
import java.util.Map;

public class AdobeOA {
    /*Given a string that consists of characters (, ), [, ]and ?,
    determine how many ways it can be split into two non-empty substrings such that
    the characters in each substring can be rearranged into a balanced string.
    The question marks can take the place of any needed character,
    and the substrings together must contain the entire string.
    In a balanced string, there are no overlapping mixed brackets.
    For example, ([]) is a balanced string where ([)] is not.*/

    //test
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("Should be 2: " + solution1("[(?][??["));
        System.out.println("Should be 1: " + solution1("(())(?"));

//        System.out.println("Should be 0: " + solution2("(((?"));
//        System.out.println("Should be 1: " + solution2("(())(?"));
    }

    public static int solution1(String input) {
        int count = 0;
        if (input.length() % 2 != 0)
            return -1;

        // Iterate through the string with step of 2
        for (int i = 1; i <= input.length() - 2; i = i + 2) {
            if (isBalance(input, 0, i) && isBalance(input, i + 1, input.length() - 1)) {
                count++;
            }
        }

        return count;
    }


    public static boolean isBalance(String a, int s, int e) {
        String sub = a.substring(s, e + 1);
        int countQ = 0;
        int number1 = 0; int number2  =0;

        for (int i = 0; i < sub.length(); i++) {
            char ch = sub.charAt(i);
            if (ch == '[' ) {
                number1++;
            } else if (ch == ']' ) {
                number1--;
            } else if(ch == '('){
                number2++;

            }else if(ch == ')'){
                number2--;
            }else{
                countQ++;
            }
        }

        // Check if the substring is balanced
//        if (countQ % 2 == 0 && number == 0) {
//            return true;
//        } else if (countQ % 2 == 1) {
//            if(number == 1 || number == -1){
//                return true;
//            }
//
//        }
        if(Math.abs(number1) + Math.abs(number2) - countQ==0)
            return true;
        if(countQ - Math.abs(number1) - Math.abs(number2) > 0)
            if((countQ - Math.abs(number1) - Math.abs(number2))% 2==0)
                return true;


        return false;
    }
    public static int solution2(String input) {
        Map<Character, Integer> rightHalf = new HashMap<>();
        Map<Character, Integer> leftHalf = new HashMap<>();
        int result = 0;

        for (int i = 0; i < input.length(); i ++) {
            int temp = rightHalf.getOrDefault(input.charAt(i), 0);
            rightHalf.put(input.charAt(i), temp + 1);
        }

        for (int i = 0; i < input.length() - 1; i ++) {
            char c = input.charAt(i);
            int temp = leftHalf.getOrDefault(c, 0);
            leftHalf.put(c, temp + 1);
            rightHalf.put(c, rightHalf.get(c) - 1);
            if (isValid(leftHalf) && isValid(rightHalf)) {
                result ++;
            }
        }

        return result;
    }

    public static boolean isValid(Map<Character, Integer> map) {
        int misSquare = Math.abs(map.getOrDefault('[', 0) - map.getOrDefault(']', 0));
        int misParen = Math.abs(map.getOrDefault('(', 0) - map.getOrDefault(')', 0));
        int question = map.getOrDefault('?', 0);

        int remain = question - misSquare - misParen;

        if (remain == 0) {
            return true;
        }
        if (remain > 0 && remain % 2 == 0) {
            return true;
        }
        return false;

    }


}

//Time : O(n^2)
//Space : O(1)
