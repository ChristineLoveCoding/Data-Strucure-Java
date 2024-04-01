import java.util.Stack;

public class EvaluationPostfix {

    public static void main(String[] args) {
        int te = postfix("23*54*+9-");
        int te2 = prefix("-+*23*549");
        String te3 = infixToPostfix("2*3+5*4-9");
        System.out.println(te3);
        System.out.println("The test result is : "+te);

        System.out.println("test2 : "+ te2);
        System.out.println("test3 :" + te3);


    }
    public static String infixToPostfix(String a){
        Stack<Character> st3 = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= a.length()-1; i++) {
            char k = a.charAt(i);
            if(Character.isDigit(k)){
                res.append(k);
            }else{
                while (!st3.isEmpty() && priority(k) < priority(st3.peek()) ){
                    char h = st3.pop();
                    res.append(h);
                }

                st3.push(k);

            }

        }

        while (!st3.isEmpty()){
            res.append(st3.pop());
        }

        return res.toString();


    }

    public static int priority(char c){
        if(c == '+' ||  c == '-'){
            return 1;
        }else if (c == '*' || c == '/') {
            return 3;
        }

        return 0;
    }

    public static int prefix(String a){
        Stack<Integer> st = new Stack<>();

        for (int i = a.length()-1; i >=0 ; i--) {
            char b = a.charAt(i);
            if(Character.isDigit(b)){
                st.push(Character.getNumericValue(b));
            }else{

                int d = st.pop();
                int d2 = st.pop();
                int res = calculator(b,d,d2);
                st.push(res);
            }

        }
        return st.peek();

    }

    public static int postfix(String s){
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char j = s.charAt(i);
            if(Character.isDigit(j)){
                stack.push(Character.getNumericValue(j));
            }else{
                char a = j;
                int c = stack.pop();
                int b = stack.pop();
                int d = calculator(a, b, c);
                stack.push(d);

            }

        }

        return stack.pop();
    }

    public static int calculator(char a, int b, int c){

        switch (a){
            case '+': return  b+c;
            case '-': return  b-c;
            case '*': return  b*c;
            case '/': return  b/c;


        }

        return -1;

    }

}
