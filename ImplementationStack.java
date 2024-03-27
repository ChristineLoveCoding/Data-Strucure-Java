public class ImplementationStack {

    int[] A = new int[100];
    int capacity = 100;
    int top = -1;

    public ImplementationStack() {

    }

    void push(int x ){
        this.top = top + 1;
        if(top + 1 > 100){
            this.capacity = capacity*2;

        }
        A[top] = x;

    }

    int pop(){
        if(top < 0){
            throw new IndexOutOfBoundsException("The stack is empty.");
        }
        int before = top;
        this.top = top - 1;
        return A[before];

    }

    boolean isEmpty(){
        if(top < 0){
            return true;
        }
        return false;

    }
     int peek(){
        if(top < 0){
            throw new IndexOutOfBoundsException("The stack is empty.");
        }
        return A[top];
     }

     int size(){
        if(top+1 < 0){
            throw new IndexOutOfBoundsException("The stack is empty.");
        }
        return top+1;
     }

}
