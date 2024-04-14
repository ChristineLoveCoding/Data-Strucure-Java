public class QueueImplementationArray {
    //implement queue using array []

    int[] A;
    int front;
    int rear;

    QueueImplementationArray(){
        A = new int[100];
        front = -1;
        rear = -1;
    }

    public static void main(String[] args) {
        QueueImplementationArray ts = new QueueImplementationArray();
        System.out.println(ts.isEmpty());ts.offer(234);ts.offer(34);
        System.out.println(ts.peek());ts.poll();
        System.out.println(ts.peek());
        System.out.println(ts.isEmpty());
    }

    //offer(int x), poll(),isEmpty(),peek() : o(1)

    //isEmpty(), O(1)

    boolean isEmpty(){
        if(this.front == -1 && this.rear == -1){
            return true;
        }

        return false;
    }

    //Offer(int x),
     void offer(int x){
        if(rear == 100-1){
            throw new RuntimeException("Max limit exceed !");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
            A[rear] = x;

        }else{
            rear++;
            A[rear] =x;
        }

     }

     void poll(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty!");
        } else if(front == rear){
            front = -1;
            rear=-1;

        }else front = front +1;

     }

     int peek(){
        if(front < 0){
            throw new IllegalArgumentException("The queue is empty.");
        }
        return A[front];
     }


}
