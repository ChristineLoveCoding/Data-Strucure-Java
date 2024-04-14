public class Queue1 {

    int[] arr = new int[10];
    int front = -1;
    int rear = -1;

    boolean isEmpty(){
        if(this.front == -1 && this.rear == -1){
            return true;
        }

        return false;
    }
}
