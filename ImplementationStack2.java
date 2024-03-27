public class ImplementationStack2 {
    //implement a stack using linked list
    ListNode top = null;


    int value = 0 ;

    int s = 0;




    void push(int x){
        ListNode t = new ListNode();
        t.val = x ;
        t.next = top;
        top = t;
        this.s = s+1;

    }

    int pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("The stack is empty.");
        }
        int p = top.val;
        top = top.next;
        s--;

        return p;

    }

    int peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("The stack is empty.");
        }
        return top.val;

    }

    boolean isEmpty(){


        return top == null;
    }

    int size(){
        return s;
    }


}
