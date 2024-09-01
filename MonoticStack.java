import java.util.Deque;
import java.util.LinkedList;

public class MonoticStack {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,5,4};
        monotoneStack(test);

    }

    public static void monotoneStack(int[] nums) {

        Deque<Integer> d = new LinkedList<>();d.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            while(!d.isEmpty() && d.peek() > nums[i]) {
                int t = d.pop();
                System.out.println(t);
            }

            d.push(nums[i]);



        }
        System.out.println(d.peek());

    }
}
