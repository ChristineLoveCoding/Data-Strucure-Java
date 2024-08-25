package Christine;
import java.util.ArrayList;
import java.util.List;


public class ImplementationQueue1 {
    // using array to implement queue

    //first-in, first-out
    List<Integer> l;
    int size;

    ImplementationQueue1(){
        l = new ArrayList<>();
        size = 0;
    }

    void offer(int i){
        l.add(i);
        size++;


    }

    void poll(){
        l.remove(0);
        size--;

    }

    int peek(){
        return l.get(size-1);
    }

    boolean isEmpty(){
        if(this.size ==0){
            return true;
        }
        return false;
    }
}
