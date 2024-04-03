import java.util.LinkedList;
import java.util.List;

public class ImplementationQueue2 {

    //using linked-list to implement the queue

    List<Integer> l2 ;
     int size;

    ImplementationQueue2(){
        l2 = new LinkedList<>();
        size = 0;
    }
    void offer(int i){
        l2.add(i);
        size++;

    }

    void poll(){
        l2.remove(0);
        size--;


    }

    int peek(){
        return l2.get(size-1);
    }

    boolean isEmpty(){
        if(this.size == 0){
            return true;
        }

        return false;

    }

    int size(){
        return size;

    }





}
